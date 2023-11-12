package xxl.app.main;

import pt.tecnico.uilib.forms.Form;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;
import xxl.app.exception.InvalidCellRangeException;
import xxl.core.Calculator;

/**
 * Open a new file.
 */
public class DoNew extends Command<Calculator> {

  DoNew(Calculator receiver) {
    super(Label.NEW, receiver);
    addIntegerField("lines", Message.lines());
    addIntegerField("columns", Message.columns());
  }

  @Override
  protected final void execute() throws CommandException {
    if (_receiver.getSpreadsheet() != null) {
      if (_receiver.getSpreadsheet().getChanged() && Form.confirm(Message.saveBeforeExit())) {
        new DoSave(_receiver).performCommand();
      }
    }
    try {
      _receiver.createNewSpreadSheet(integerField("lines"), integerField("columns"));
    } catch (InvalidCellRangeException e) {
      _display.addLine(e.getMessage());
      _display.display();
    }

  }
}