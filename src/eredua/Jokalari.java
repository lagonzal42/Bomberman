package eredua;

public abstract class Jokalari extends Gelaxka{
	
	private int xPos;
	private int yPos;
	
	public void mugituGora(){
		if (Matrizea.getMatrizea().getGelaxka(xPos, yPos+1) instanceof Hutsik){
			this.yPos = this.yPos +1;
		}
	}
	
	public void mugituBehera(){
		if (Matrizea.getMatrizea().getGelaxka(xPos, yPos-1) instanceof Hutsik){
			this.yPos = this.yPos -1;
		}
	}
	
	public void mugituEzkerra(){
		if (Matrizea.getMatrizea().getGelaxka(xPos-1, yPos) instanceof Hutsik){
			this.xPos = this.xPos -1;
		}
	}
	
	public void mugituEskuma() {
		if (Matrizea.getMatrizea().getGelaxka(xPos+1, yPos) instanceof Hutsik){
			this.xPos = this.xPos +1;
		}
	}
}
