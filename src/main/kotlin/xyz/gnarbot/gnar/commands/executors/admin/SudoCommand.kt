package xyz.gnarbot.gnar.commands.executors.admin

import xyz.gnarbot.gnar.Bot
import xyz.gnarbot.gnar.commands.Category
import xyz.gnarbot.gnar.commands.Command
import xyz.gnarbot.gnar.commands.CommandExecutor
import xyz.gnarbot.gnar.utils.Context

@Command(
        id = 33,
        aliases = arrayOf("sudo"),
        description = "Power.",
        admin = true,
        category = Category.NONE
)
class SudoCommand : CommandExecutor() {
    override fun execute(context: Context, label: String, args: Array<String>) {
        if (args.isEmpty()) {
            context.send().error("Put a command pls.").queue()
            return
        }

        val cmd = Bot.getCommandRegistry().getCommand(args[0])

        if (cmd == null) {
            context.send().error("Not a valid command.").queue()
            return
        }

        cmd.execute(context, args[0], args.copyOfRange(1, args.size))
    }
}