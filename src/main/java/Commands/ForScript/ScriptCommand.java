package Commands.ForScript;

import InputHandler.InputProvider;

import java.io.BufferedReader;
import java.io.IOException;

public interface ScriptCommand {
    void execute(BufferedReader reader) throws IOException;
}
