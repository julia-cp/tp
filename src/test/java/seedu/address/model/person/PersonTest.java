package seedu.address.model.person;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.VALID_EMAIL_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_EMAIL_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_PHONE_BOB;
import static seedu.address.testutil.TypicalPersons.ALICE;
import static seedu.address.testutil.TypicalPersons.BOB;

import org.junit.jupiter.api.Test;

import seedu.address.testutil.PersonBuilder;

public class PersonTest {

    @Test
    public void isSameIdentity_sameObject_returnsTrue() {
        assertTrue(ALICE.isSameIdentity(ALICE));
    }

    @Test
    public void isSameIdentity_null_returnsFalse() {
        assertFalse(ALICE.isSameIdentity(null));
    }

    @Test
    public void isSameIdentity_diffNameDiffPhoneDiffEmail_returnsFalse() {
        // different name, phone number and email, all other attributes same -> false
        Person editedAlice = new PersonBuilder(ALICE).withName(VALID_NAME_BOB).withPhone(VALID_PHONE_BOB)
                .withEmail(VALID_EMAIL_BOB).build();
        assertFalse(ALICE.isSameIdentity(editedAlice));
    }

    @Test
    public void isSameIdentity_diffCategory_returnsTrue() {
        // different category, all other attributes same -> true
        Person editedAlice = new PersonBuilder(ALICE).withCategory("STAFF").build();
        assertTrue(ALICE.isSameIdentity(editedAlice));
    }

    @Test
    public void isSameIdentity_diffCategoryDiffName_returnsFalse() {
        // different category and name, all other attributes same -> false
        Person editedAlice = new PersonBuilder(ALICE).withCategory("STAFF").withName(VALID_NAME_BOB).build();
        assertFalse(ALICE.isSameIdentity(editedAlice));
    }

    @Test
    public void isSameIdentity_diffCategoryDiffPhone_returnsTrue() {
        // different category and phone number, all other attributes same -> true
        Person editedAlice = new PersonBuilder(ALICE).withCategory("STAFF").withPhone(VALID_PHONE_BOB).build();
        assertTrue(ALICE.isSameIdentity(editedAlice));
    }

    @Test
    public void isSameIdentity_diffCategoryDiffEmail_returnsTrue() {
        // different category and email, all other attributes same -> true
        Person editedAlice = new PersonBuilder(ALICE).withCategory("STAFF").withEmail(VALID_EMAIL_BOB).build();
        assertTrue(ALICE.isSameIdentity(editedAlice));
    }

    @Test
    public void isSameIdentity_sameNameAndPhoneOtherDiff_returnsTrue() {
        Person editedAlice = new PersonBuilder(ALICE).withEmail(VALID_EMAIL_AMY).withComment("some comment").build();
        assertTrue(ALICE.isSameIdentity(editedAlice));
    }

    @Test
    public void isSameIdentity_sameNameDiffPhone_returnsFalse() {
        // different phone number and email, all other attributes same -> false
        Person editedAlice = new PersonBuilder(ALICE).withPhone(VALID_PHONE_BOB).withEmail(VALID_EMAIL_AMY).build();
        assertFalse(ALICE.isSameIdentity(editedAlice));
    }

    @Test
    public void isSameIdentity_diffNameSamePhone_returnsFalse() {
        // different name, all other attributes same -> false
        Person editedAlice = new PersonBuilder(ALICE).withName(VALID_NAME_BOB).build();
        assertFalse(ALICE.isSameIdentity(editedAlice));

        // different name and email, all other attributes same -> false
        editedAlice = new PersonBuilder(ALICE).withName(VALID_NAME_BOB).withEmail(VALID_EMAIL_AMY).build();
        assertFalse(ALICE.isSameIdentity(editedAlice));
    }

    @Test
    public void isSameIdentity_diffNameDiffPhone_returnsFalse() {
        // different name and phone number, all other attributes same -> false
        Person editedAlice = new PersonBuilder(ALICE).withName(VALID_NAME_BOB).withPhone(VALID_PHONE_BOB).build();
        assertFalse(ALICE.isSameIdentity(editedAlice));
    }

    @Test
    public void equals() {
        // same values -> returns true
        Person aliceCopy = new PersonBuilder(ALICE).build();
        assertTrue(ALICE.equals(aliceCopy));

        // same object -> returns true
        assertTrue(ALICE.equals(ALICE));

        // null -> returns false
        assertFalse(ALICE.equals(null));

        // different type -> returns false
        assertFalse(ALICE.equals(5));

        // different person -> returns false
        assertFalse(ALICE.equals(BOB));

        // different name -> returns false
        Person editedAlice = new PersonBuilder(ALICE).withName(VALID_NAME_BOB).build();
        assertFalse(ALICE.equals(editedAlice));

        // different phone -> returns false
        editedAlice = new PersonBuilder(ALICE).withPhone(VALID_PHONE_BOB).build();
        assertFalse(ALICE.equals(editedAlice));

        // different email -> returns false
        editedAlice = new PersonBuilder(ALICE).withEmail(VALID_EMAIL_BOB).build();
        assertFalse(ALICE.equals(editedAlice));
    }

    @Test
    public void toStringMethod() {
        String expected = Participant.class.getCanonicalName() + "{name=" + ALICE.getName()
                + ", phone=" + ALICE.getPhone() + ", email=" + ALICE.getEmail()
                + ", category=" + ALICE.getCategory() + ", comment=" + ALICE.getComment()
                + ", group=" + ALICE.getGroup() + "}";
        assertEquals(expected, ALICE.toString());
    }
}
