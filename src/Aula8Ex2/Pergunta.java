package Aula8Ex2;

import java.util.Arrays;

public class Pergunta {
	private String level;
	private String ask;
	private String urlImage;
	private String[] options;
	private String answer;
	
	public Pergunta(String level, String ask, String urlImage, String[] options, String answer){
		this.level = level;
		this.ask = ask;
		this.urlImage = urlImage.replace(":", "/");
		this.options = options;
		this.answer = answer;
	}
	
	@Override 
	public String toString(){
		return ask;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pergunta other = (Pergunta) obj;
		if (answer == null) {
			if (other.answer != null)
				return false;
		} else if (!answer.equals(other.answer))
			return false;
		if (ask == null) {
			if (other.ask != null)
				return false;
		} else if (!ask.equals(other.ask))
			return false;
		if (level != other.level)
			return false;
		if (!Arrays.equals(options, other.options))
			return false;
		if (urlImage == null) {
			if (other.urlImage != null)
				return false;
		} else if (!urlImage.equals(other.urlImage))
			return false;
		return true;
	}

	public String urlImage(){
		return urlImage;
	}
	
	public String level(){
		return level;
	}
	
	public String[] options(){
		return options;
	}
	
	public String answer(){
		return answer;
	}
	
}