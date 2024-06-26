package seedu.address.model;

import java.nio.file.Path;
import java.util.function.Predicate;

import javafx.collections.ObservableList;
import seedu.address.commons.core.GuiSettings;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.ReversibleCommand;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.logic.commands.exceptions.UndoException;
import seedu.address.model.event.Event;
import seedu.address.model.person.Person;

/**
 * The API of the Model component.
 */
public interface Model {
    /** {@code Predicate} that always evaluate to true */
    Predicate<Person> PREDICATE_SHOW_ALL_PERSONS = unused -> true;
    Predicate<Event> PREDICATE_SHOW_ALL_EVENTS = unused -> true;

    /**
     * Replaces user prefs data with the data in {@code userPrefs}.
     */
    void setUserPrefs(ReadOnlyUserPrefs userPrefs);

    /**
     * Returns the user prefs.
     */
    ReadOnlyUserPrefs getUserPrefs();

    /**
     * Returns the user prefs' GUI settings.
     */
    GuiSettings getGuiSettings();

    /**
     * Sets the user prefs' GUI settings.
     */
    void setGuiSettings(GuiSettings guiSettings);

    /**
     * Returns the user prefs' address book file path.
     */
    Path getAddressBookFilePath();

    /**
     * Sets the user prefs' address book file path.
     */
    void setAddressBookFilePath(Path addressBookFilePath);

    /**
     * Replaces address book data with the data in {@code addressBook}.
     */
    void setAddressBook(ReadOnlyAddressBook addressBook);

    /** Returns the AddressBook */
    ReadOnlyAddressBook getAddressBook();

    /** Returns the EventBook */
    ReadOnlyEventBook getEventBook();

    /**
     * Returns true if a person with the same identity as {@code person} exists in
     * the address book.
     */
    boolean hasPerson(Person person);

    /**
     * Deletes the given person. The person must exist in the address book.
     */
    void deletePerson(Person target);

    /**
     * Adds the given person. {@code person} must not already exist in the address
     * book.
     */
    void addPerson(Person person);

    /**
     * Replaces the given person {@code target} with {@code editedPerson}.
     * {@code target} must exist in the address book. The person identity of
     * {@code editedPerson} must not be the same as another existing person in the
     * address book.
     */
    void setPerson(Person target, Person editedPerson);

    /**
     * Groups the given person {@code target} into {@code groupNumber}.
     * {@code target} must exist in the address book.
     * {@code groupNumber} must be a positive integer.
     */
    void groupPerson(Person target, int groupNumber);

    /** Returns an unmodifiable view of the filtered person list */
    ObservableList<Person> getFilteredPersonList();

    /**
     * Updates the filter of the filtered person list to filter by the given
     * {@code predicate}.
     *
     * @throws NullPointerException if {@code predicate} is null.
     */
    void updateFilteredPersonList(Predicate<Person> predicate);


    /**
     * Returns true if the model has previous address book states to restore.
     *
     * @return True if the model has previous address book states to restore, false
     *         otherwise.
     */
    boolean canUndoAddressBook();

    /**
     * Returns true if the model has undone address book states to restore.
     *
     * @return True if the model has undone address book states to restore, false
     *         otherwise.
     */
    boolean canRedoAddressBook();

    /**
     * Restores the model's address book to its previous state.
     *
     * @return The result of the undo operation.
     */
    CommandResult undoAddressBook() throws UndoException;

    /**
     * Restores the model's address book to its previously undone state.
     *
     * @return The result of the redo operation.
     */
    CommandResult redoAddressBook() throws UndoException, CommandException;

    /**
     * Adds a reversible command to the history for undo/redo.
     */
    void addCommand(ReversibleCommand command);

    void addEvent(Event event);
    void deleteEvent(Event event);
    boolean hasEvent(Event event);
    void setEvent(Event target, Event editedEvent);
    void updateFilteredEventList(Predicate<Event> predicate);
    ObservableList<Event> getFilteredEventList();
    Path getEventBookFilePath();
    public void setEventBook(ReadOnlyEventBook eventBook);
    public void setEventBookFilePath(Path eventBookFilePath);
}
