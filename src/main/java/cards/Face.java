package cards;

public class Face {
    private final int faceValue;
    private final String faceName;

    public Face(int faceValue, String faceName) {
        this.faceValue = faceValue;
        this.faceName = faceName;
    }

    public Face(int faceValue) {
        this.faceValue = faceValue;
        faceName = "" + faceValue;
    }

    public int getFaceValue() {
        return faceValue;
    }

    public String getFaceName() {
        return faceName;
    }

    @Override
    public String toString() {
        return faceName;
    }
}
