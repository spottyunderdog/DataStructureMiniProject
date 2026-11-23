package moduleA;

public class Resource implements Identifiable {
    private final int id;
    private final String name;
    private final String category;
    private final String building;
    private boolean availability;
    private int popularityScore;


    public Resource(int resourceId, String resourceName, String resourceCat,
                    String building, boolean isAvailable, int popularity) {
        this.id = resourceId;
        this.name = resourceName;
        this.category = resourceCat;
        this.building = building;
        this.availability = isAvailable;
        this.popularityScore = popularity;
    }

    @Override
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCatagory() {
        return category;
    }

    public String getBuilding() { return building; }

    public void setAvailability(boolean status) {
        availability = status;
    }

    public boolean getAvailability() {
        return availability;
    }

    public int getPopularityScore() {
        return popularityScore;
    }

    public void incrementPopularityScore() { popularityScore++; }

    @Override
    public boolean equals(Object o) {
        return o instanceof Resource other && other.getId() == this.id;
    }
    @Override
    public String toString() {
        return String.format("[%d] %-22s | %-18s | %-22s | %-11s | popularity %d",
                id, name, category, building,
                availability ? "Available" : "Unavailable", popularityScore);
    }

}
