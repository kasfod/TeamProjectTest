package game_userDTO;

public class GameUserDTO {
	private int seq;
	private String writer;
	private String message;
	private String write_date;
	
	public GameUserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public GameUserDTO(int seq, String writer, String message, String write_date) {
		super();
		this.seq = seq;
		this.writer = writer;
		this.message = message;
		this.write_date = write_date;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getWrite_date() {
		return write_date;
	}

	public void setWrite_date(String write_date) {
		this.write_date = write_date;
	}
	
	
}
