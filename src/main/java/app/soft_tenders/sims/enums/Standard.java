package app.soft_tenders.sims.enums;

public enum Standard {
    KINDERGARTEN(0),
    FIRST(1),
    SECOND(2),
    THIRD(3),
    FOURTH(4),
    FIFTH(5),
    SIXTH(6),
    SEVENTH(7),
    EIGHTH(8),
    NINTH(9),
    TENTH(10),
    ELEVENTH(11),
    TWELFTH(12);

    private final int standardId;

    Standard(int standardId) {
        this.standardId = standardId;
    }

    public Standard fromNumber(int id) {
        for (Standard Standard : Standard.values()) {
            if (Standard.toNumber() == id) {
                return Standard;
            }
        }
        throw new IllegalArgumentException("Invalid standard id: " + id);
    }

    public int toNumber() {
        return this.standardId;
    }
}

