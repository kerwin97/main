package seedu.address.model.reminder;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Represents a Reminder in the calendar.
 */
public class Reminder {
    // Identity fields
    private final ReminderDescription reminderDescription;
    private final Set<ReminderTime> reminderTimeSet = new HashSet<>();

    /**
     * Every field must be present and not null.
     */
    public Reminder(ReminderDescription reminderDescription, Set<ReminderTime> reminderTime) {
        requireAllNonNull(reminderDescription);
        this.reminderDescription = reminderDescription;
        reminderTimeSet.addAll(reminderTime);
    }



    public ReminderDescription getDescription() {
        return reminderDescription;
    }

    public Set<ReminderTime> getTime() {
        return Collections.unmodifiableSet(reminderTimeSet);
    }


    /**
     * Returns true if both tasks has the same description.
     * This defines a weaker notion of equality between two tasks.
     */
    public boolean isSameReminder(Reminder otherReminder) {
        if (otherReminder == this) {
            return true;
        }

        return otherReminder != null
                && otherReminder.getDescription().equals(getDescription());
    }

    /**
     * Returns true if both persons have the same identity and data fields.
     * This defines a stronger notion of equality between two persons.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Reminder)) {
            return false;
        }

        Reminder otherReminder = (Reminder) other;
        return otherReminder.getDescription().equals(getDescription())
                && otherReminder.getTime().equals(getTime());
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(reminderDescription, reminderTimeSet);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(" Description: ")
                .append(getDescription())
                .append(" Time: ")
                .append(getTime());
        return builder.toString();
    }
}
