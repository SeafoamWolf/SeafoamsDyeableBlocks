package seafoamwolf.seafoamsdyeableblocks.commands;

import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.minecraft.item.ItemStack;
import net.minecraft.server.command.ServerCommandSource;
import seafoamwolf.seafoamsdyeableblocks.item.DyeableItems;
import seafoamwolf.seafoamsdyeableblocks.item.PaintbrushItem;

import static com.mojang.brigadier.arguments.IntegerArgumentType.getInteger;
import static net.minecraft.server.command.CommandManager.literal;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.Command;
import com.mojang.brigadier.arguments.IntegerArgumentType;

import static net.minecraft.server.command.CommandManager.argument;

public class DyeableCommands {
    public static void register() {
        CommandRegistrationCallback.EVENT.register((CommandDispatcher<ServerCommandSource> dispatcher, boolean dedicated) ->
            dispatcher.register(
                literal("givedye")
                .requires(source -> source.hasPermissionLevel(4))
                .then(argument("color", IntegerArgumentType.integer(0, 16777215))
                    .executes(context -> {
                        ItemStack dye = new ItemStack(DyeableItems.NETHERITE_PAINTBRUSH);
                        ((PaintbrushItem)(dye.getItem())).setColor(dye, getInteger(context, "color"));

                        context.getSource().getPlayer().getInventory().insertStack(dye);

                        return Command.SINGLE_SUCCESS; // Success
                    })
                )
            )
        );
    }
}
