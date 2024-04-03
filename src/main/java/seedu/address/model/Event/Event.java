package seedu.address.model.Event;

import java.util.Objects;

public class Event {
    private final EventName eventName;
    private final EventCategory eventCategory;
    private final EventDate eventDate;

    public Event(EventName eventName, EventDate eventDate, EventCategory eventCategory) {
        this.eventName = eventName;
        this.eventCategory = eventCategory;
        this.eventDate = eventDate;
    }

    public EventName getEventName() {
        return this.eventName;
    }

    public EventCategory getEventCategory() {
        return this.eventCategory;
    }
    public EventDate getEventDate() { return this.eventDate; }

    /**
     * Returns true if both events have the same event name and event category.
     * This defines a weaker notion of equality between two events.
     */
    public boolean isSameEvent(Event otherEvent) {
        if (otherEvent == this) {
            return true;
        }

        return otherEvent != null
                && otherEvent.getEventName().equals(getEventName())
                && otherEvent.getEventCategory().equals(getEventCategory());
    }

    /**
     * Returns true if both events have the same event name and event category.
     * This defines a stronger notion of equality between two events.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof Event)) {
            return false;
        }

        Event otherEvent = (Event) other;
        return eventName.equals(otherEvent.eventName)
                && eventCategory.equals(otherEvent.eventCategory);
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(eventName, eventCategory);
    }

    @Override
    public String toString() {
        return "Event{" +
                "eventName=" + eventName +
                ", eventCategory=" + eventCategory +
                '}';
    }


}
    

