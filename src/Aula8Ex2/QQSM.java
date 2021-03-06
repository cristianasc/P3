package Aula8Ex2;

import java.io.File;
import java.io.FileNotFoundException;

public class QQSM {
	
		private Pergunta[] asks;
		private boolean fiftyfifty = true;
		private boolean call = true;
		private boolean publico = true;
		private int[] prize = {25, 50, 125, 250, 500, 750, 1500, 2500,
				5000, 10000, 16000, 32000, 64000, 125000, 250000};
		private int atualPrize;
		private int n = 0;
		
		public QQSM(File file) throws FileNotFoundException{
			InfoFile parser = new InfoFile(file);
			asks = parser.getAsks();
			this.atualPrize = -1;
		}
		
		public Pergunta getRandomAsk(){
			int rand = (int)(Math.random()*(asks.length-1));
			this.atualPrize++;
			this.n++;
			return asks[rand];
		}
		
		public int getPrize(){
			return prize[atualPrize];
		}
		
		public boolean getFiftyfifty(){
			return fiftyfifty;
		}
		
		public boolean getCall(){
			return call;
		}
		
		public boolean getPublico(){
			return publico;
		}
		
		public void setFiftyFifty(){
			this.fiftyfifty = false;
		}
		
		public void setCall(){
			this.call = false;
		}
		
		public void setPublico(){
			this.publico = false;
		}
		
		public int getN(){
			return this.n;
		}
}
