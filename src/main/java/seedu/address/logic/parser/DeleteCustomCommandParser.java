package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.DeleteCommand;
import seedu.address.logic.commands.DeleteCustomCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.commands.CommandObject;

/**
 * Parses input arguments and creates a new DeleteCommand object
 */
public class DeleteCustomCommandParser implements Parser<DeleteCustomCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the DeleteCommand
     * and returns a DeleteCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public DeleteCustomCommand parse(String args) throws ParseException {
        try {
            CommandObject commandToDelete = ParserUtil.parseCommand(args);
            return new DeleteCustomCommand(commandToDelete);
        } catch (ParseException pe) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, DeleteCustomCommand.MESSAGE_USAGE), pe);
        }
    }

}
