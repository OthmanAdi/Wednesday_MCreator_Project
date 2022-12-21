package net.mcreator.tntmod.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.arguments.MessageArgument;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.CommandSourceStack;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;

public class SetDisplayNameProcedure {
	public static void execute(CommandContext<CommandSourceStack> arguments) {
		try {
			for (Entity entityiterator : EntityArgument.getEntities(arguments, "targets")) {
				entityiterator.setCustomName(Component.literal((new Object() {
					public String getMessage() {
						try {
							return MessageArgument.getMessage(arguments, "displayname").getString();
						} catch (CommandSyntaxException ignored) {
							return "";
						}
					}
				}).getMessage()));
			}
		} catch (CommandSyntaxException e) {
			e.printStackTrace();
		}
	}
}
