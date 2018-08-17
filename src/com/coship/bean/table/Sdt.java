package com.coship.bean.table;

import java.util.ArrayList;
import java.util.List;


public class Sdt {
	/**
     * tableId : 8 bit
     */
    private int tableId = 0x42;

    /**
     * section_syntax_indicator : 1 bit
     */
    private int sectionSyntaxIndicator = 0x1;

    /**
     * zero : 1 bit
     */
    private int reservedFutureUse1;

    /**
     * reserved_1 : 2 bit
     */
    private int reserved1;

    /**
     * sectionLength : 12 bit
     */
    private int sectionLength = 0;

    /**
     * transport_stream_id : 16 bit
     */
    private int transportStreamId;

    /**
     * reserved_2 : 2 bit
     */
    private int reserved2;

    /**
     * version_number : 5 bit
     */
    private int versionNumber;

    /**
     * current_next_indicator : 1 bit
     * 发送的PAT是当前有效还是下一个PAT有效
     */
    private int currentNextIndicator;

    /**
     * section_number : 8 bit
     */
    private int sectionNumber;

    /**
     * last_section_number 8 bit
     */
    private int lastSectionNumber;
    
    
    /**
     * 16 bit
     */
    private int originalNerworkId;
    
    


	/**
     * 8 bit
     */
    private int reservedFutureUse2;


    private List<SdtService> sdtServiceList = new ArrayList<>();

    /**
     * CRC_32 : 32 bit
     */
    private int crc32;
    
    public Sdt(byte[] sectionData) {
        super();
        int tableId = sectionData[0] & 0xFF;
        int sectionSyntaxIndicator = (sectionData[1] >> 7) & 0x1;
        int reservedFutureUse1 = (sectionData[1] >> 6) & 0x1;
        int reserved1 = (sectionData[1] >> 4) & 0x3;
        int sectionLength = (((sectionData[1] & 0xF) << 8) | (sectionData[2] & 0xFF)) & 0xFFF;
        int transportStreamId = ((sectionData[3] & 0xFF) | (sectionData[4] & 0xFF)) & 0xFFFF;
        int reserved2 = (sectionData[5] >> 6) & 0x3;
        int versionNumber = (sectionData[5] >> 1) & 0x1F;
        int currentNextIndicator = sectionData[5] & 0x1;
        int sectionNumber = sectionData[6] & 0xFF;
        int lastSectionNumber = sectionData[7] & 0xFF;
        int originalNerworkId = sectionData[8] &0xFF;
        int reservedFutureUse2 = (((sectionData[9]&0xFF)<<8)|(sectionData[10]&0xFF)) & 0xFFFF;
        
        int crc32 = (((((sectionData[sectionData.length - 4] & 0xFF)<<8
        		|(sectionData[sectionData.length - 3] & 0xFF))&0xffff)<<16)
        		|(((sectionData[sectionData.length - 2] & 0xFF)<<8
        		|(sectionData[sectionData.length - 1] & 0xFF))&0xffff))&0xffffffff;
        
        
        this.tableId = tableId;
        this.sectionSyntaxIndicator = sectionSyntaxIndicator;
        this.reservedFutureUse1 = reservedFutureUse1;
        this.reserved1 = reserved1;
        this.sectionLength = sectionLength;
        this.transportStreamId = transportStreamId;
        this.reserved2 = reserved2;
        this.versionNumber = versionNumber;
        this.currentNextIndicator = currentNextIndicator;
        this.sectionNumber = sectionNumber;
        this.lastSectionNumber = lastSectionNumber;
        this.originalNerworkId = originalNerworkId;
        this.reservedFutureUse2 = reservedFutureUse2;
        this.crc32 = crc32;
    }

	public int getTableId() {
		return tableId;
	}

	public void setTableId(int tableId) {
		this.tableId = tableId;
	}

	public int getSectionSyntaxIndicator() {
		return sectionSyntaxIndicator;
	}

	public void setSectionSyntaxIndicator(int sectionSyntaxIndicator) {
		this.sectionSyntaxIndicator = sectionSyntaxIndicator;
	}

	public int getReservedFutureUse1() {
		return reservedFutureUse1;
	}

	public void setReservedFutureUse1(int reservedFutureUse1) {
		this.reservedFutureUse1 = reservedFutureUse1;
	}
	
	public int getReservedFutureUse2() {
		return reservedFutureUse2;
	}

	public void setReservedFutureUse2(int reservedFutureUse2) {
		this.reservedFutureUse2 = reservedFutureUse2;
	}

	public int getReserved1() {
		return reserved1;
	}

	public void setReserved1(int reserved1) {
		this.reserved1 = reserved1;
	}

	public int getSectionLength() {
		return sectionLength;
	}

	public void setSectionLength(int sectionLength) {
		this.sectionLength = sectionLength;
	}

	public int getTransportStreamId() {
		return transportStreamId;
	}

	public void setTransportStreamId(int transportStreamId) {
		this.transportStreamId = transportStreamId;
	}

	public int getReserved2() {
		return reserved2;
	}

	public void setReserved2(int reserved2) {
		this.reserved2 = reserved2;
	}

	public int getVersionNumber() {
		return versionNumber;
	}

	public void setVersionNumber(int versionNumber) {
		this.versionNumber = versionNumber;
	}

	public int getCurrentNextIndicator() {
		return currentNextIndicator;
	}

	public void setCurrentNextIndicator(int currentNextIndicator) {
		this.currentNextIndicator = currentNextIndicator;
	}

	public int getSectionNumber() {
		return sectionNumber;
	}

	public void setSectionNumber(int sectionNumber) {
		this.sectionNumber = sectionNumber;
	}

	public int getLastSectionNumber() {
		return lastSectionNumber;
	}

	public void setLastSectionNumber(int lastSectionNumber) {
		this.lastSectionNumber = lastSectionNumber;
	}
	
    public int getOriginalNerworkId() {
		return originalNerworkId;
	}

	public void setOriginalNerworkId(int originalNerworkId) {
		this.originalNerworkId = originalNerworkId;
	}

	public List<SdtService> getSdtServiceList() {
		return sdtServiceList;
	}

	public void setSdtServiceList(List<SdtService> sdtServiceList) {
		this.sdtServiceList = sdtServiceList;
	}

	public int getCrc32() {
		return crc32;
	}

	public void setCrc32(int crc32) {
		this.crc32 = crc32;
	}
    
    
    
}