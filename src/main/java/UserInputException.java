import java.util.Arrays;
import java.util.List;
class UserInputException extends Exception {
    static void checkUserInput(String input, int currentSize) throws DukeException {
        String[] inputSplitArray = input.split(" ");
        List<String> inputSplitList = Arrays.asList(inputSplitArray);
        String command = inputSplitList.get(0);
        if (command.equals("TODO")) {
            if (inputSplitList.size() <= 1) {
                throw new DukeException("EMPTY TO-DO COMMAND... DOING NOTHING MUCH?");
            }
        } else if (command.equals("DEADLINE")) {
            if (input.contains(" /BY ")) {
                if (inputSplitList.size() <= 3) {
                    throw new DukeException("MORE INFO NEEDED FOR DEADLINE");
                }
            } else {
                throw new DukeException("NO DEADLINE. FREE TIME ISN'T SO EASY TO COME BY.");
            }
        } else if (command.equals("EVENT")) {
            if (input.contains(" /FROM ") && input.contains(" /TO ")) {
                if (inputSplitList.size() <= 5) {
                    throw new DukeException("MORE INFO NEEDED FOR EVENT");
                }
            } else {
                throw new DukeException("MY CREATOR DIDN'T MAKE ME SMART ENOUGH TO INFER INFO FROM THIS...");
            }
        } else if (command.equals("MARK")) {
            if (inputSplitList.size() == 1) {
                throw new DukeException("MY CREATOR DIDN'T MAKE ME SMART ENOUGH TO INFER INFO FROM THIS...");
            }
            if (inputSplitList.size() > 2) {
                throw new DukeException("TOO MUCH INFO...");
            } else {
                if (Integer.valueOf(inputSplitList.get(1)) > currentSize) {
                    if (currentSize > 1) {
                        throw new DukeException("YOU ONLY HAVE " + currentSize + " TASKS");
                    } else {
                        throw new DukeException("YOU ONLY HAVE " + currentSize + " TASK");
                    }
                }
            }

        } else if (command.equals("UNMARK")) {
            if (inputSplitList.size() == 1) {
                throw new DukeException("MY CREATOR DIDN'T MAKE ME SMART ENOUGH TO INFER INFO FROM THIS...");
            }
            if (inputSplitList.size() > 2) {
                throw new DukeException("TOO MUCH INFO...");
            } else {
                if (Integer.valueOf(inputSplitList.get(1)) > currentSize) {
                    throw new DukeException("YOU DON'T HAVE THAT MANY TASKS");
                }
            }

        } else if (command.equals("DELETE")) {
            if (inputSplitList.size() > 2) {
                throw new DukeException("TOO MUCH INFO...");
            } else {
                if (Integer.valueOf(inputSplitList.get(1)) > currentSize) {
                    throw new DukeException("YOU DON'T HAVE THAT MANY TASKS");
                }
            }

        } else if (command.equals("LIST")) {
            if (inputSplitList.size() > 1) {
                throw new DukeException("ARE YOU EXPECTING ME TO DO SOMETHING WITH THE EXTRA INFO?");
            }
        } else {
            throw new DukeException("COMMAND NOT FOUND... WHAT ARE YOU UP TO...");
        }
    }
}