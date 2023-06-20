package com.marpol.iolist.models;

public class IoListDto {

	public long ioSEQ;// NUMBER
	public String ioDate;// VARCHAR2(10)
	public String ioTime;// VARCHAR2(10)
	public String ioBuid;// VARCHAR2(10)
	public String ioPCode;// VARCHAR2(13)
	public int ioQuan;// NUMBER
	public int ioPrice;// NUMBER
	public int ioTotal;// NUMBER

	public IoListDto(long ioSEQ, String ioDate, String ioTime, String ioBuid, String ioPCode, int ioQuan, int ioPrice,
			int ioTotal) {
		super();
		this.ioSEQ = ioSEQ;
		this.ioDate = ioDate;
		this.ioTime = ioTime;
		this.ioBuid = ioBuid;
		this.ioPCode = ioPCode;
		this.ioQuan = ioQuan;
		this.ioPrice = ioPrice;
		this.ioTotal = ioTotal;
	}

	public IoListDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "IoListDto [ioSEQ=" + ioSEQ + ", ioDate=" + ioDate + ", ioTime=" + ioTime + ", ioBuid=" + ioBuid
				+ ", ioPCode=" + ioPCode + ", ioQuan=" + ioQuan + ", ioPrice=" + ioPrice + ", ioTotal=" + ioTotal + "]";
	}

}
