package positions;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
/* * For keeping a player's details */
public class Player {
    private String name;
    private String position;
    private double pts;
    private double trb;
    private double ast;
    private double blk;
    private double stl;


    public Player(String name, String position, double pts, double trb, double ast, double blk, double stl) {
        this.name = name;
        this.position = position;
        this.pts = pts;
        this.trb = trb;
        this.ast = ast;
        this.blk = blk;
        this.stl = stl;
    }

    @Override
    public String toString() {
        return    name 
                 ;
    }
    

    
    public String toString(String name) {
    	return "Name: " + name + "\nPosition: " + position + "\nPTS: " + pts + "\nTRB: " + trb + "\nAST: " + ast + "\nBLK: " + blk + "\nSTL: " + stl;
    }
    /** calculates the score for pg position*/
    public int calculatePointGuardScore() {
        Random random = new Random();
        double score = 0;
        

        score += calculateScoreForAttribute(pts, PointGuard.getPtsWeight(), random);
        score += calculateScoreForAttribute(trb, PointGuard.getTrbWeight(), random);
        score += calculateScoreForAttribute(ast, PointGuard.getAstWeight(), random);
        score += calculateScoreForAttribute(blk, PointGuard.getBlkWeight(), random);
        score += calculateScoreForAttribute(stl, PointGuard.getStlWeight(), random);

        return (int) Math.round(score);
    }
    /** calculates the score for center position*/
    public int calculateCenterScore() {
        Random random = new Random();
        double score = 0;

        score += calculateScoreForAttribute(pts, Center.getPtsWeight(), random);
        score += calculateScoreForAttribute(trb, Center.getTrbWeight(), random);
        score += calculateScoreForAttribute(ast, Center.getAstWeight(), random);
        score += calculateScoreForAttribute(blk, Center.getBlkWeight(), random);
        score += calculateScoreForAttribute(stl, Center.getStlWeight(), random);

        return (int) Math.round(score);
    }
    /** calculates the score for pf position*/
    
    public int calculatePowerForwardScore() {
        Random random = new Random();
        double score = 0;

        score += calculateScoreForAttribute(pts, PowerForward.getPtsWeight(), random);
        score += calculateScoreForAttribute(trb, PowerForward.getTrbWeight(), random);
        score += calculateScoreForAttribute(ast, PowerForward.getAstWeight(), random);
        score += calculateScoreForAttribute(blk, PowerForward.getBlkWeight(), random);
        score += calculateScoreForAttribute(stl, PowerForward.getStlWeight(), random);

        return (int) Math.round(score);
    }
    /** calculates the score for sg position*/
    public int calculateShootingGuardScore() {
        Random random = new Random();
        double score = 0;

        score += calculateScoreForAttribute(pts, ShootingGuard.getPtsWeight(), random);
        score += calculateScoreForAttribute(trb, ShootingGuard.getTrbWeight(), random);
        score += calculateScoreForAttribute(ast, ShootingGuard.getAstWeight(), random);
        score += calculateScoreForAttribute(blk, ShootingGuard.getBlkWeight(), random);
        score += calculateScoreForAttribute(stl, ShootingGuard.getStlWeight(), random);

        return (int) Math.round(score);
    }
    /** calculates the score for sf position*/
    public int calculateSmallForwardScore() {
        Random random = new Random();
        double score = 0;

        score += calculateScoreForAttribute(pts, SmallForward.getPtsWeight(), random);
        score += calculateScoreForAttribute(trb, SmallForward.getTrbWeight(), random);
        score += calculateScoreForAttribute(ast, SmallForward.getAstWeight(), random);
        score += calculateScoreForAttribute(blk, SmallForward.getBlkWeight(), random);
        score += calculateScoreForAttribute(stl, SmallForward.getStlWeight(), random);

        return (int) Math.round(score);
    }

    

    public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public double getPts() {
		return pts;
	}
	public void setPts(double pts) {
		this.pts = pts;
	}
	public double getTrb() {
		return trb;
	}
	public void setTrb(double trb) {
		this.trb = trb;
	}
	public double getAst() {
		return ast;
	}
	public void setAst(double ast) {
		this.ast = ast;
	}
	public double getBlk() {
		return blk;
	}
	public void setBlk(double blk) {
		this.blk = blk;
	}
	public double getStl() {
		return stl;
	}
	public void setStl(double stl) {
		this.stl = stl;
	}
	
	/** @param value  will be multiplied by the weight
	 * @param weight weight for the specific value
	 * @param random random class 
	 * @return calculated score*/
	private double calculateScoreForAttribute(double value, double weight, Random random) {

        int N = 5;


        double randomValue = value + random.nextGaussian() * N;

        randomValue = Math.max(randomValue, 0);

        return randomValue * weight;
    }
}












