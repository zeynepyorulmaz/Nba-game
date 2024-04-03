package positions;
/* * For players in SG position */
public class ShootingGuard extends Player {
    private static final double PTS_WEIGHT = 0.25;
    private static final double TRB_WEIGHT = 0.1;
    private static final double AST_WEIGHT = 0.2;
    private static final double BLK_WEIGHT = 0.15;
    private static final double STL_WEIGHT = 0.3;

    public ShootingGuard(String name, double pts, double trb, double ast, double blk, double stl) {
        super(name, "SG", pts, trb, ast, blk, stl);
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
