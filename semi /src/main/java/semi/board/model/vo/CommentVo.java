package semi.board.model.vo;

import java.sql.Date;

public class CommentVo {
	
	/*
	 * COMMENT_NO|ANIMAL_NO_|COMMENT_DATE              |COMMENT_WRITER|COMMENT_COMMENT|
----------+----------+--------------------------+--------------+---------------+
         1|         2|2023-02-17 20:44:56.295741|익명            |댓글 테스트 1       |
         2|         1| 2023-02-17 20:45:59.92593|익명            |댓글 테스트 2       |
         3|         3|2023-02-17 20:46:11.276972|익명            |댓글 테스트 2       |
	 */
	
	private int commentNo;
	private int animalNo;
	private Date commentDate;
	private String commentWriter;
	private String commentcomment;
	
	public int getCommentNo() {
		return commentNo;
	}
	public void setCommentNo(int commentNo) {
		this.commentNo = commentNo;
	}
	public int getAnimalNo() {
		return animalNo;
	}
	public void setAnimalNo(int animalNo) {
		this.animalNo = animalNo;
	}
	public Date getCommentDate() {
		return commentDate;
	}
	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}
	public String getCommentWriter() {
		return commentWriter;
	}
	public void setCommentWriter(String commentWriter) {
		this.commentWriter = commentWriter;
	}
	public String getCommentcomment() {
		return commentcomment;
	}
	public void setCommentcomment(String commentcomment) {
		this.commentcomment = commentcomment;
	}
	@Override
	public String toString() {
		return "CommentVo [commentNo=" + commentNo + ", animalNo=" + animalNo + ", commentDate=" + commentDate
				+ ", commentWriter=" + commentWriter + ", commentcomment=" + commentcomment + "]";
	}
	public CommentVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CommentVo(int commentNo, int animalNo, Date commentDate, String commentWriter, String commentcomment) {
		super();
		this.commentNo = commentNo;
		this.animalNo = animalNo;
		this.commentDate = commentDate;
		this.commentWriter = commentWriter;
		this.commentcomment = commentcomment;
	}
	
	
	

}
