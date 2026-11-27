package ModuleG;

import moduleA.Identifiable;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ServiceRequest implements Identifiable {

    private final int requestId;
    private final String studentName;
    private final String category;
    private final String building;
    private final String description;
    private final int sequenceNumber;
    private final LocalDateTime submittedAt;

    public ServiceRequest(int requestId, String studentName, String category,
                          String building, String description, int sequenceNumber) {
        this.requestId = requestId;
        this.studentName = studentName;
        this.category = category;
        this.building = building;
        this.description = description;
        this.sequenceNumber = sequenceNumber;
        this.submittedAt = LocalDateTime.now();
    }

    @Override
    public int getId() { return requestId; }
    public String getStudentName() { return studentName; }
    public String getCategory() { return category; }
    public String getBuilding() { return building; }
    public String getDescription() { return description; }
    public int getSequenceNumber() { return sequenceNumber; }

    @Override
    public String toString() {
        return String.format("Request #%d (seq %d, %s) | %s | %s @ %s | \"%s\"",
                requestId, sequenceNumber,
                submittedAt.format(DateTimeFormatter.ofPattern("HH:mm:ss")),
                studentName, category, building, description);
    }
}
