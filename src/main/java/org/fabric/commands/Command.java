package org.fabric.commands;

import java.util.List;

public interface Command {
    void execute(List<String> parameters);
}
