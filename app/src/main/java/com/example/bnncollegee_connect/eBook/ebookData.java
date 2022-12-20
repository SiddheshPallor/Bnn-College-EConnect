package com.example.bnncollegee_connect.eBook;

public class ebookData {
    private String pdfTitle, pdfUrl;

    public ebookData() {
    }

    public ebookData(String pdfTitle, String pdfUrl) {
        this.pdfTitle = pdfTitle;
        this.pdfUrl = pdfUrl;
    }

    public String getPdfTitle() {
        return pdfTitle;
    }

    public void setPdfTitle(String pdfTitle) {
        this.pdfTitle = pdfTitle;
    }

    public String getPdfUrl() {
        return pdfUrl;
    }

    public void setPdfUrl(String pdfUrl) {
        this.pdfUrl = pdfUrl;
    }

    //    public ebookData(String pdfTitle, String pdfUrl) {
//        this.pdfTitle = pdfTitle;
//        this.pdfUrl = pdfUrl;
//    }
//
//    public String getName() {
//        return pdfTitle;
//    }
//
//    public void setName(String pdfTitle) {
//        this.pdfTitle = pdfTitle;
//    }
//
//    public String getPdfUrl() {
//        return pdfUrl;
//    }
//
//    public void setPdfUrl(String pdfUrl) {
//        this.pdfUrl = pdfUrl;
//    }
}
