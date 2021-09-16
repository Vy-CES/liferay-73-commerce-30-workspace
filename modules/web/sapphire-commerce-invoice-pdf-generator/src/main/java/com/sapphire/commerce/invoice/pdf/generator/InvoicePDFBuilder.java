package com.sapphire.commerce.invoice.pdf.generator;

import be.quodlibet.boxable.*;
import be.quodlibet.boxable.image.Image;
import be.quodlibet.boxable.line.LineStyle;
import be.quodlibet.boxable.utils.FontUtils;
import be.quodlibet.boxable.utils.PDStreamUtils;
import be.quodlibet.boxable.utils.PageContentStreamOptimized;
import com.sapphire.commerce.invoice.pdf.generator.constants.InvoicePDFGeneratorConstants;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.PDPageTree;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class InvoicePDFBuilder {

    public static File buildSupplierPDF(
            long commerceOrderId, String[] billingAddress, String[] shippingAddress,
            String[] productHeaders, List<String[]> productInformation, String[] invoiceInfoTableData, String[] balanceValueTable, String[] remitanceTable)
            throws IOException {

        // Set margins
        float margin = 32;

        // Initialize Document
        PDDocument doc = new PDDocument();
        PDPage page = addNewPage(doc);

        float YStartProductTable = page.getMediaBox().getHeight() - 310f;
        float marginBottom = 70f;
        float contentHeightInOnePage = YStartProductTable - marginBottom;

        float totalHeightOfProductInfoTable = writeProductInfoTable(doc, page, margin, productHeaders, productInformation, YStartProductTable, marginBottom);
        addSummaryPage(doc, productHeaders, margin, balanceValueTable, remitanceTable, YStartProductTable, marginBottom, contentHeightInOnePage, totalHeightOfProductInfoTable);
        writeHeader(doc, margin, billingAddress, shippingAddress, invoiceInfoTableData);
        addPageNumbers(doc,"Page {0} of {1}",60,15, margin);

        StringBuilder pdfName = new StringBuilder();

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(
                "yyyy-MM-dd");
        LocalDateTime now = LocalDateTime.now();

        String timestamp = dtf.format(now);

        pdfName.append("Invoice-"
        ).append(
                commerceOrderId
        ).append(
                "_"
        ).append(
                timestamp
        ).append(
                ".pdf"
        );

        File pdf = new File(pdfName.toString());
        doc.save(pdf);
        doc.close();
        return pdf;
    }

    private static float writeProductInfoTable(PDDocument doc, PDPage page, float margin, String[] productHeaders, List<String[]> productInformation, float YStartProductTable, float marginBottom) throws IOException {
        // Initialize table
        float tableWidth = page.getMediaBox().getWidth() - (2 * margin);
        float yStart = YStartProductTable;
        float rowHeight = 15f;

        float productInfoHeightTotal = 0;


        BaseTable table = new BaseTable(yStart, YStartProductTable, marginBottom, tableWidth, margin, doc, page, true, true);

        Row<PDPage> tableHeaderRow = createTableHeaderRow(table, rowHeight, productHeaders);
        productInfoHeightTotal += tableHeaderRow.getHeight();

        table.addHeaderRow(tableHeaderRow);

        //Add order item
        Row<PDPage> productRow;
        Cell<PDPage> productCell;
        for (String[] product:  productInformation) {
            productRow = table.createRow(rowHeight);
            for (int i = 0; i < product.length - 1; i++) {
                if (i == 0) {
                    productCell = productRow.createCell(getCellWidth(i, productHeaders.length), product[i], HorizontalAlignment.LEFT, VerticalAlignment.MIDDLE);
                    productCell.setLeftBorderStyle(new LineStyle(Color.WHITE, 0));
                } else if (i > 1) {
                    productCell = productRow.createCell(getCellWidth(i, productHeaders.length), product[i],HorizontalAlignment.RIGHT, VerticalAlignment.MIDDLE);
                } else {
                    productCell = productRow.createCell(getCellWidth(i, productHeaders.length), product[i], HorizontalAlignment.LEFT, VerticalAlignment.MIDDLE);
                }
                productCell.setFont(PDType1Font.HELVETICA);
                productCell.setTopBorderStyle(new LineStyle(Color.WHITE, 0));
                productCell.setBottomBorderStyle(new LineStyle(Color.WHITE, 0));
                productCell.setRightBorderStyle(new LineStyle(Color.WHITE, 0));
            }
            productInfoHeightTotal += productRow.getHeight();
        }
        table.draw();
        return productInfoHeightTotal;
    }

    private static void addSummaryPage(PDDocument doc, String[] productHeaders, float margin,
                                       String[] balanceValueTable, String[] remitanceTable,
                                       float YStartProductTable, float marginBottom, float contentHeightInOnePage, float totalHeightOfProductInfoTable) throws IOException {
        float fontSize = 7f;
        float firstLineY = 190f;
        float secondLineY = 90f;
        float lineHeight = 0.5f;
        PDPage page;
        float totalSpaceHeightRemainOnTheLastPage = contentHeightInOnePage - (totalHeightOfProductInfoTable % contentHeightInOnePage);
        if (totalSpaceHeightRemainOnTheLastPage > firstLineY) {
            page = doc.getPage(doc.getNumberOfPages() - 1);
        } else {
            page = addNewPage(doc);
        }
        // Initialize table
        float tableWidth = page.getMediaBox().getWidth() - (2 * margin);
        float yStart = YStartProductTable;
        float rowHeight = 15f;
        BaseTable table = new BaseTable(yStart, YStartProductTable, marginBottom, tableWidth, margin, doc, page, true, true);
        table.addHeaderRow(createTableHeaderRow(table, rowHeight, productHeaders));
        table.draw();

        PDPageContentStream contentStream = new PDPageContentStream(doc, page, PDPageContentStream.AppendMode.APPEND, true, false);
        PDStreamUtils.rect(new PageContentStreamOptimized(contentStream), 0 + margin, firstLineY, page.getMediaBox().getWidth() - (2 * margin), lineHeight, InvoicePDFGeneratorConstants.GRAY_COLOR);
        PDStreamUtils.rect(new PageContentStreamOptimized(contentStream), 0 + margin + 10f, secondLineY, page.getMediaBox().getWidth() - (2 * margin), lineHeight, InvoicePDFGeneratorConstants.GRAY_COLOR);

        Image logo2 = new Image(ImageIO.read(InvoicePDFBuilder.class.getResource("/logo/cuttt.png")));
        logo2 = logo2.scaleByWidth(10);
        logo2.draw(doc, new PageContentStreamOptimized(contentStream), 0 + margin, secondLineY + 4f);


        float startTextY = firstLineY - 15f;
        float secondLineTextStartY = secondLineY - 10f;
        float lineSpacing = FontUtils.getHeight(PDType1Font.HELVETICA, fontSize) + 5f;

        contentStream.setNonStrokingColor(Color.BLACK);
        contentStream.beginText();
        contentStream.setFont(PDType1Font.HELVETICA_BOLD, fontSize);
        contentStream.newLineAtOffset(margin, startTextY - lineSpacing);
        contentStream.showText("Note:Out of Stock Items will not be Backordered.");
        contentStream.endText();

        contentStream.beginText();
        contentStream.setFont(PDType1Font.HELVETICA_BOLD, fontSize);
        contentStream.newLineAtOffset(margin, startTextY - (lineSpacing * 6.5f));
        contentStream.showText("Remitance Advice:");
        contentStream.endText();

        //SecondLineText

        contentStream.beginText();
        contentStream.setFont(PDType1Font.HELVETICA, fontSize);
        contentStream.newLineAtOffset(margin, secondLineTextStartY - lineSpacing);
        contentStream.showText("Ownership of these products does not pass until payment is made in full.");
        contentStream.endText();

        contentStream.beginText();
        contentStream.setFont(PDType1Font.HELVETICA, fontSize);
        contentStream.newLineAtOffset(margin, secondLineTextStartY - (lineSpacing * 2));
        contentStream.showText("We accept Mastercard and Visa.");
        contentStream.endText();

        contentStream.close();

        writeInvoiceBalanceSummaryTable(doc, page, firstLineY, balanceValueTable);
        writeRemitanceAdviceTable(doc, page, secondLineY, remitanceTable);
    }

    private static void writeRemitanceAdviceTable(PDDocument doc, PDPage page, float secondLineY, String[] remitanceTable) throws IOException {
        BaseTable table1 = new BaseTable(secondLineY - 10f, secondLineY - 10f, 10, 250, 415, doc, page, true, true);

        float table1Height = 5f;
        float fontSize = 7f;
        float padding = 2f;
        float cellLeftWidth = 35f;
        float cellRightWidth = 25f;

        String[] remitanceHeader = new String[3];
        remitanceHeader[0] = "Account No.";
        remitanceHeader[1] = "Invoice No.";
        remitanceHeader[2] = "Paid:";

        Row<PDPage> row;
        Cell<PDPage> cell1;
        for (int i = 0; i < remitanceHeader.length; i++) {

            if (i == remitanceHeader.length - 1) {
                row = table1.createRow(table1Height);
                cell1 = row.createCell(cellLeftWidth, remitanceHeader[i], HorizontalAlignment.LEFT, VerticalAlignment.BOTTOM);
                cell1.setFont(PDType1Font.HELVETICA_BOLD);
                cell1.setFontSize(fontSize + 3f);
                cell1.setTopPadding(padding + 2f);
                cell1.setBottomPadding(padding);
                hideCellBorder(cell1);

                cell1 = row.createCell(cellRightWidth, remitanceTable[i], HorizontalAlignment.LEFT, VerticalAlignment.BOTTOM);
                cell1.setFontSize(fontSize + 3f);
                cell1.setTopPadding(padding + 2f);
                cell1.setBottomPadding(padding);
                cell1.setBottomBorderStyle(new LineStyle(Color.BLACK, 1));
                cell1.setTopBorderStyle(new LineStyle(Color.WHITE, 0));
                cell1.setLeftBorderStyle(new LineStyle(Color.WHITE, 0));
                cell1.setRightBorderStyle(new LineStyle(Color.WHITE, 0));

                continue;
            }
            row = table1.createRow(table1Height);
            cell1 = row.createCell(cellLeftWidth, remitanceHeader[i], HorizontalAlignment.LEFT, VerticalAlignment.BOTTOM);
            cell1.setFont(PDType1Font.HELVETICA_BOLD);
            cell1.setFontSize(fontSize);
            cell1.setTopPadding(padding);
            cell1.setBottomPadding(padding);
            hideCellBorder(cell1);

            cell1 = row.createCell(cellRightWidth, remitanceTable[i], HorizontalAlignment.LEFT, VerticalAlignment.BOTTOM);
            cell1.setFontSize(fontSize);
            cell1.setTopPadding(padding);
            cell1.setBottomPadding(padding);
            hideCellBorder(cell1);
        }
        table1.draw();
    }

    private static void hideCellBorder(Cell<PDPage> cell) {
        cell.setTopBorderStyle(new LineStyle(Color.WHITE, 0));
        cell.setBottomBorderStyle(new LineStyle(Color.WHITE, 0));
        cell.setRightBorderStyle(new LineStyle(Color.WHITE, 0));
        cell.setLeftBorderStyle(new LineStyle(Color.WHITE, 0));
    }

    private static void writeInvoiceBalanceSummaryTable(PDDocument doc, PDPage page, float firstLineY, String[] balanceValueTable) throws IOException {
        BaseTable table1 = new BaseTable(firstLineY - 10f, firstLineY - 10f, 70, 250, 415, doc, page, true, true);

        float table1Height = 5f;
        float fontSize = 7f;
        float padding = 2f;
        float cellLeftWidth = 35f;
        float cellRightWidth = 25f;

        String[] balanceValueHeaderTable = new String[3];
        balanceValueHeaderTable[0] = "Total:";
        balanceValueHeaderTable[1] = "Paid:";
        balanceValueHeaderTable[2] = "Balance:";

        Row<PDPage> row;
        Cell<PDPage> cell1;
        for (int i = 0; i < balanceValueTable.length; i++) {
            if (i == balanceValueTable.length - 1) {
                row = table1.createRow(table1Height);
                cell1 = row.createCell(cellLeftWidth, balanceValueHeaderTable[i], HorizontalAlignment.LEFT, VerticalAlignment.BOTTOM);
                cell1.setFont(PDType1Font.HELVETICA_BOLD);
                cell1.setFontSize(fontSize + 3f);
                cell1.setTopPadding(padding + 2f);
                cell1.setBottomPadding(padding);
                hideCellBorder(cell1);

                cell1 = row.createCell(cellRightWidth, balanceValueTable[i], HorizontalAlignment.RIGHT, VerticalAlignment.BOTTOM);
                cell1.setFontSize(fontSize + 3f);
                cell1.setTopPadding(padding + 2f);
                cell1.setBottomPadding(padding);
                cell1.setTopBorderStyle(new LineStyle(Color.BLACK, 0));
                cell1.setBottomBorderStyle(new LineStyle(Color.WHITE, 0));
                cell1.setLeftBorderStyle(new LineStyle(Color.WHITE, 0));
                cell1.setRightBorderStyle(new LineStyle(Color.WHITE, 0));

                continue;
            }

            row = table1.createRow(table1Height);
            cell1 = row.createCell(cellLeftWidth, balanceValueHeaderTable[i], HorizontalAlignment.LEFT, VerticalAlignment.BOTTOM);
            cell1.setFont(PDType1Font.HELVETICA_BOLD);
            cell1.setFontSize(fontSize);
            cell1.setTopPadding(padding);
            cell1.setBottomPadding(padding);
            hideCellBorder(cell1);

            if (i == balanceValueTable.length - 2) {
                cell1 = row.createCell(cellRightWidth, balanceValueTable[i], HorizontalAlignment.RIGHT, VerticalAlignment.BOTTOM);
                cell1.setFontSize(fontSize);
                cell1.setTopPadding(padding);
                cell1.setBottomPadding(padding);
                cell1.setTopBorderStyle(new LineStyle(Color.WHITE, 0));
                cell1.setBottomBorderStyle(new LineStyle(Color.BLACK, 1));
                cell1.setLeftBorderStyle(new LineStyle(Color.WHITE, 0));
                cell1.setRightBorderStyle(new LineStyle(Color.WHITE, 0));
            } else {
                cell1 = row.createCell(cellRightWidth, balanceValueTable[i], HorizontalAlignment.RIGHT, VerticalAlignment.BOTTOM);
                cell1.setFontSize(fontSize);
                cell1.setTopPadding(padding);
                cell1.setBottomPadding(padding);
                hideCellBorder(cell1);
            }

        }
        table1.draw();
    }

    private static Row<PDPage> createTableHeaderRow(BaseTable table, float rowHeight, String[] productHeaders) {
        // Create Header row
        Row<PDPage> headerRow = table.createRow(rowHeight);

        for (int i = 0; i < productHeaders.length; i++) {
            String columnHeader = productHeaders[i];
            float cellWidth = getCellWidth(i, productHeaders.length);
            Cell<PDPage> cell;
            if (i == 0) {
                cell = headerRow.createCell(cellWidth, columnHeader, HorizontalAlignment.LEFT, VerticalAlignment.MIDDLE);
                cell.setLeftBorderStyle(new LineStyle(Color.WHITE, 0));
            } else if (i > 1) {
                cell = headerRow.createCell(cellWidth, columnHeader,HorizontalAlignment.RIGHT, VerticalAlignment.MIDDLE);
            } else {
                cell = headerRow.createCell(cellWidth, columnHeader, HorizontalAlignment.LEFT, VerticalAlignment.MIDDLE);
            }
            cell.setFont(PDType1Font.HELVETICA_BOLD);
            cell.setTextColor(Color.BLACK);
            cell.setTopBorderStyle(new LineStyle(InvoicePDFGeneratorConstants.GRAY_COLOR, 0.75f));
            cell.setBottomBorderStyle(new LineStyle(InvoicePDFGeneratorConstants.GRAY_COLOR, 0.75f));
            cell.setRightBorderStyle(new LineStyle(Color.WHITE, 0));
        }
        return headerRow;
    }

    public static void addPageNumbers(PDDocument document, String numberingFormat, int offset_X, int offset_Y, float margin) throws IOException {
        int page_counter = 1;
        PDPageTree pages = document.getPages();
        int count = pages.getCount();
        for(PDPage page : pages){

            PDRectangle pageSize = page.getMediaBox();
            float x = pageSize.getLowerLeftX();
            float y = pageSize.getLowerLeftY();

            PDPageContentStream contentStream = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.APPEND, true, false);
            PDStreamUtils.rect(new PageContentStreamOptimized(contentStream), 0 + margin, y+offset_Y+10, page.getMediaBox().getWidth() - (2 * margin), 0.5f, InvoicePDFGeneratorConstants.GRAY_COLOR);

            contentStream.beginText();
            contentStream.setFont(PDType1Font.HELVETICA, 7);
            contentStream.setNonStrokingColor(Color.BLACK);
            contentStream.newLineAtOffset(x+ pageSize.getWidth()-offset_X - 10, y+offset_Y);
            String text = MessageFormat.format(numberingFormat,page_counter, count);
            contentStream.showText(text);
            contentStream.endText();
            contentStream.close();
            ++page_counter;
        }
    }


    private static void writeHeader(PDDocument doc, float margin, String[] billingAddress, String[] shippingAddress, String[] invoiceInfoTableData) throws IOException {
        for (PDPage page : doc.getPages()) {
            PDPageContentStream contentStream = new PDPageContentStream(doc, page, PDPageContentStream.AppendMode.APPEND, true, false);
            contentStream.setNonStrokingColor(Color.BLACK);

            Image logo1 = new Image(ImageIO.read(InvoicePDFBuilder.class.getResource("/logo/kolanot_brand_logo-high.jpg")));
            float imageWidth = 300;
            logo1 = logo1.scaleByWidth(imageWidth);
            logo1.draw(doc, new PageContentStreamOptimized(contentStream), 155f, 800f);

//            Image logo2 = new Image(ImageIO.read(InvoicePDFBuilder.class.getResource("/logo/logo2.png")));
//            logo2 = logo2.scaleByWidth(imageWidth);
//            logo2.draw(doc, new PageContentStreamOptimized(contentStream), 155f, 770f);

            writeInvoiceAddress(contentStream, margin);

            float yStart1 = 700;

            contentStream.beginText();
            contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);
            contentStream.newLineAtOffset(420, yStart1);
            contentStream.showText("Tax Invoice No. " + invoiceInfoTableData[0]);
            contentStream.endText();

            writeInvoiceInfoTable(doc, page, yStart1, invoiceInfoTableData);

            writeAddress(contentStream, margin, billingAddress, false);
            writeAddress(contentStream, margin, shippingAddress, true);

            contentStream.close();
        }
    }

    private static void writeAddress(PDPageContentStream contentStream, float margin, String[] address, boolean isShipping) throws IOException {
            float fontSize = 7f;
            float startX;
            float startY = 600f;
            String addressTitle;
            if (isShipping) {
                startX = 300f;
                addressTitle = "Ship To:";
            } else {
                startX = margin;
                addressTitle = "Invoice To:";
            }

            float contentStartX = startX + FontUtils.getStringWidth(PDType1Font.HELVETICA_BOLD, addressTitle, fontSize) + 5f;
            float contentHeightMinus = FontUtils.getHeight(PDType1Font.HELVETICA, fontSize) + 5f;

            contentStream.beginText();
            contentStream.setFont(PDType1Font.HELVETICA_BOLD, fontSize);
            contentStream.newLineAtOffset(startX, startY);
            contentStream.showText(addressTitle);
            contentStream.endText();

            for (int i = 0; i < address.length; i++) {
                contentStream.beginText();
                contentStream.setFont(PDType1Font.HELVETICA, fontSize);
                contentStream.newLineAtOffset(contentStartX, startY - (contentHeightMinus * i));
                contentStream.showText(address[i]);
                contentStream.endText();
            }
    }

    private static void writeInvoiceInfoTable(PDDocument doc, PDPage page, float yStart, String[] invoiceInfoTableData) throws IOException {
        BaseTable table1 = new BaseTable(yStart - 5, yStart - 5, 70, 250, 415, doc, page, false, true);

        float table1Height = 5f;
        float fontSize = 7f;
        float padding = 2f;

        String[] titles = new String[6];
        titles[0] = "Invoice Date:";
        titles[1] = "PO No:";
        titles[2] = "Ordered By:";
        titles[3] = "Account No:";
        titles[4] = "Currency:";


        for (int i = 0; i < titles.length; i++) {
            Row<PDPage> row = table1.createRow(table1Height);
            Cell<PDPage> cell1 = row.createCell(30f, titles[i], HorizontalAlignment.LEFT, VerticalAlignment.BOTTOM);
            cell1.setFont(PDType1Font.HELVETICA_BOLD);
            cell1.setFontSize(fontSize);
            cell1.setTopPadding(padding);
            cell1.setBottomPadding(padding);
            cell1 = row.createCell(30f, invoiceInfoTableData[i+1], HorizontalAlignment.RIGHT, VerticalAlignment.BOTTOM);
            cell1.setFontSize(fontSize);
            cell1.setTopPadding(padding);
            cell1.setBottomPadding(padding);
        }
        table1.draw();
    }

    private static void writeInvoiceAddress(PDPageContentStream contentStream, float margin) throws IOException {
        //TODO: SAPPHIRE info
        float startY = 700;
        float fontSize = 6;

        contentStream.beginText();
        contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);
        contentStream.newLineAtOffset(margin, startY);
        contentStream.showText("Kolanot");
        contentStream.endText();

        contentStream.beginText();
        contentStream.setFont(PDType1Font.HELVETICA, fontSize);
        contentStream.newLineAtOffset(margin, startY - 15);
        contentStream.showText("Global Transportation Intelligence and Logistics Research");
        contentStream.endText();

        contentStream.beginText();
        contentStream.setFont(PDType1Font.HELVETICA, fontSize);
        contentStream.newLineAtOffset(margin, startY - 25);
        contentStream.showText("Manchester, United Kingdom");
        contentStream.endText();

        contentStream.beginText();
        contentStream.setFont(PDType1Font.HELVETICA_BOLD, fontSize);
        contentStream.newLineAtOffset(margin, startY - 35);
        contentStream.showText("P:");
        contentStream.endText();

        contentStream.beginText();
        contentStream.setFont(PDType1Font.HELVETICA, fontSize);
        contentStream.newLineAtOffset(margin + 10, startY - 35);
        contentStream.showText("+07387001059");
        contentStream.endText();

        contentStream.beginText();
        contentStream.setFont(PDType1Font.HELVETICA_BOLD, fontSize);
        contentStream.newLineAtOffset(margin, startY - 45);
        contentStream.showText("Email:");
        contentStream.endText();

        contentStream.beginText();
        contentStream.setFont(PDType1Font.HELVETICA, fontSize);
        contentStream.newLineAtOffset(margin + 25, startY - 45);
        contentStream.showText("ransome.g@googlemail.com");
        contentStream.endText();

    }

    private static PDPage addNewPage(PDDocument doc) {
        PDPage page = new PDPage(PDRectangle.A4);
        doc.addPage(page);
        return page;
    }

    private static float getCellWidth(int i, int productHeaderLength) {
        float cellWidth;
        if (i == 0) {
            cellWidth = 14f;
        } else if (i == 1) {
            cellWidth = 34f;
        } else if (i == productHeaderLength - 1) {
            cellWidth = 10f;
        }
        else {
            cellWidth = 8f;
        }
        return cellWidth;
    }

}