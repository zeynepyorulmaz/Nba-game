package positions;
/* * For players in PF position */
public class PowerForward extends Player {
    private static final double PTS_WEIGHT = 0.25;
    private static final double TRB_WEIGHT = 0.2;
    private static final double AST_WEIGHT = 0.15;
    private static final double BLK_WEIGHT = 0.2;
    private static final double STL_WEIGHT = 0.2;

    public PowerForward(String name, double pts, double trb, double ast, double blk, double stl) {
        super(name, "PF", pts, trb, ast, blk, stl);
    }

	public static double getPtsWeight() {
		return PTS_WEIGHT;
	}

	public static double getTrbWeight() {
		return TRB_WEIGHT;
	}

	public static double getAstWeight() {
		return AST_WEIGHT;
	}

	public static double getBlkWeight() {
		return BLK_WEIGHT;
	}

	public static double getStlWeight() {
		return STL_WEIGHT;
	}
}