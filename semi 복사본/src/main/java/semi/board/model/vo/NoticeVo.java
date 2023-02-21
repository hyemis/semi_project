package semi.board.model.vo;

import java.sql.Date;

public class NoticeVo {
/*
 * CREATE TABLE NOTICE(
		NOTICE_NO NUMBER NOT NULL PRIMARY KEY
	,	NOTICE_TITLE VARCHAR2(2000 BYTE) 
	,	NOTICE_WRITER VARCHAR2(20 BYTE)
	, 	NOTICE_CONTENT VARCHAR2(4000 BYTE)
	,	NOTICE_DATE TIMESTAMP DEFAULT(CURRENT_TIMESTAMP)
	, 	NOTICE_VIEWCOUNT NUMBER DEFAULT '0' 
);	
 */

	private int noticeNo;
	private String noticeTitle;
	private String noticeWriter;
	private String noticeContent;
	private Date noticeDate;
	private int noticeViewCount;
	
	public int getNoticeNo() {
		return noticeNo;
	}
	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
	}
	
	public String getNoticeTitle() {
		return noticeTitle;
	}
	
	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}
	
	public String getNoticeWriter() {
		return noticeWriter;
	}
	
	public void setNoticeWriter(String noticeWriter) {
		this.noticeWriter = noticeWriter;
	}
	
	public String getNoticeContent() {
		return noticeContent;
	}
	
	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}
	
	public Date getNoticeDate() {
		return noticeDate;
	}
	
	public void setNoticeDate(Date noticeDate) {
		this.noticeDate = noticeDate;
	}
	
	public int getNoticeViewCount() {
		return noticeViewCount;
	}
	
	public void setNoticeViewCount(int noticeViewCount) {
		this.noticeViewCount = noticeViewCount;
	}
	
	@Override
	public String toString() {
		return "NoticeVo [noticeNo=" + noticeNo + ", noticeTitle=" + noticeTitle + ", noticeWrite=" + noticeWriter
				+ ", noticeContent=" + noticeContent + ", noticeDate=" + noticeDate + ", noticeViewCount="
				+ noticeViewCount + "]";
	}
	
	public NoticeVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public NoticeVo(int noticeNo, String noticeTitle, String noticeWriter, String noticeContent, Date noticeDate,
			int noticeViewCount) {
		super();
		this.noticeNo = noticeNo;
		this.noticeTitle = noticeTitle;
		this.noticeWriter = noticeWriter;
		this.noticeContent = noticeContent;
		this.noticeDate = noticeDate;
		this.noticeViewCount = noticeViewCount;
	}
	
	
	
	

}
