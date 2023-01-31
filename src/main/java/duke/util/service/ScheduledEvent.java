package duke.util.service;

import duke.util.Task;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * A more specific implementation of {@code Task}
 * as specified by the user.
 */

public class ScheduledEvent extends Task {
    LocalDateTime dateBegin;
    LocalDateTime dateEnd;

    /**
     * Construct a {@code Deadline} with the action specified
     * by the user, as well as the beginning date and end date of the action,
     * denoted in the user input as the keywords "/FROM"
     * and "/TO".
     */
    public ScheduledEvent(LocalDateTime dateBegin, LocalDateTime dateEnd, String action) {
        super("E", action);
        this.dateBegin = dateBegin;
        this.dateEnd = dateEnd;
    }

    @Override
    public String toString() {
        return super.toString() + " (FROM: " + dateBegin.format(DateTimeFormatter.ofPattern("HH:mm MMM dd yyyy")) +
                " TO: " + dateEnd.format(DateTimeFormatter.ofPattern("HH:mm MMM dd yyyy")) + ")";
    }
}