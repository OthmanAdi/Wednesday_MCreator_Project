
package net.mcreator.tntmod.command;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegisterCommandsEvent;

import net.minecraft.commands.arguments.MessageArgument;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.Commands;

@Mod.EventBusSubscriber
public class MycommandCommand {
	@SubscribeEvent
	public static void registerCommand(RegisterCommandsEvent event) {
		event.getDispatcher().register(Commands.literal("mycommand")

				.then(Commands.argument("targets", EntityArgument.entities()).then(Commands.argument("displayname", MessageArgument.message()))));
	}
}
