package seafoamwolf.seafoamsdyeableblocks.commands;

import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.item.ItemStack;
import net.minecraft.server.command.ServerCommandSource;
import seafoamwolf.seafoamsdyeableblocks.item.DyeableItems;
import seafoamwolf.seafoamsdyeableblocks.item.DynamicDyeItem;

import static com.mojang.brigadier.arguments.IntegerArgumentType.getInteger;
import static net.minecraft.server.command.CommandManager.literal;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.arguments.IntegerArgumentType;

import static net.minecraft.server.command.CommandManager.argument;

public class DyeableCommands {
    public static void register() {
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) ->
            dispatcher.register(literal("givedye")
            .requires(source -> source.hasPermissionLevel(4))
            .then(argument("color", IntegerArgumentType.integer(0, 16777215))
            .executes(context -> givedye(context.getSource(), getInteger(context, "color"))))));
    }

    public static int givedye(ServerCommandSource source, int color) {
        ItemStack dye = new ItemStack(DyeableItems.DYNAMIC_DYE);
        ((DynamicDyeItem)(dye.getItem())).setColor(dye, color);

        source.getPlayer().getInventory().insertStack(dye);

        return Command.SINGLE_SUCCESS; // Success
    }
}
