package com.minexd.praxi.arena.command;

import com.minexd.praxi.arena.Arena;
import com.minexd.zoot.util.CC;
import com.qrakn.honcho.command.CommandMeta;
import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang.StringUtils;
import org.bukkit.command.CommandSender;

@CommandMeta(label = "arena status", permission = "praxi.admin.arena")
public class ArenaStatusCommand {

	public void execute(CommandSender sender, Arena arena) {
		if (arena != null) {
			sender.sendMessage(CC.GOLD + CC.BOLD + "Arena Status " + CC.GRAY + "(" +
			                   (arena.isSetup() ? CC.GREEN : CC.RED) + arena.getName() + CC.GRAY + ")");

			sender.sendMessage(CC.GREEN + "Cuboid Lower Location: " + CC.YELLOW +
			                   (arena.getLowerCorner() == null ?
					                   StringEscapeUtils.unescapeJava("\u2717") :
					                   StringEscapeUtils.unescapeJava("\u2713")));

			sender.sendMessage(CC.GREEN + "Cuboid Upper Location: " + CC.YELLOW +
			                   (arena.getUpperCorner() == null ?
					                   StringEscapeUtils.unescapeJava("\u2717") :
					                   StringEscapeUtils.unescapeJava("\u2713")));

			sender.sendMessage(CC.GREEN + "Spawn A Location: " + CC.YELLOW +
			                   (arena.getSpawnA() == null ?
					                   StringEscapeUtils.unescapeJava("\u2717") :
					                   StringEscapeUtils.unescapeJava("\u2713")));

			sender.sendMessage(CC.GREEN + "Spawn B Location: " + CC.YELLOW +
			                   (arena.getSpawnB() == null ?
					                   StringEscapeUtils.unescapeJava("\u2717") :
					                   StringEscapeUtils.unescapeJava("\u2713")));

			sender.sendMessage(CC.GREEN + "Kits: " + CC.YELLOW + StringUtils.join(arena.getKits(), ", "));
		} else {
			sender.sendMessage(CC.RED + "An arena with that name does not exist.");
		}
	}

}
