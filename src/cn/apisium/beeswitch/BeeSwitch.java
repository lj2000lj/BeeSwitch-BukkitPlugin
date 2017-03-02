package cn.apisium.beeswitch;

import java.io.UnsupportedEncodingException;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class BeeSwitch extends JavaPlugin implements Listener {
	static BeeSwitch instence;

	public void onEnable() {
		BeeSwitch.instence = this;
		Bukkit.getMessenger().registerOutgoingPluginChannel(this, "BeeSwitch");
		Bukkit.getPluginManager().registerEvents(this, this);
		getLogger().info("�۷��л����سɹ�");
		getLogger().info("====================");
		getLogger().info("�۷乤���� BeeStudio");
		getLogger().info("      ������Ʒ");
		getLogger().info("����QQȺ��367428642");
		getLogger().info("====================");
	}

	public void onDisable() {
		getLogger().info("�۷��л��Ѿ�ж��");
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(label.equalsIgnoreCase("beeswitch")))
			return false;
		if (args.length == 2) {
			Player player = Bukkit.getServer().getPlayer(args[0]);
			if (player == null) {
				sender.sendMessage("�л������Ҳ�����ҡ�");
				return true;
			}
			try {
				switchServer(player, args[1]);
			} catch (UnsupportedEncodingException e) {
				player.sendMessage("�л�����");
			}
			return true;
		}
		sender.sendMessage("�л�������������");
		return true;
	}

	public static BeeSwitch getInstence() {
		return instence;
	}

	public void switchServer(Player player, String ip) throws UnsupportedEncodingException {
		player.sendPluginMessage(this, "BeeSwitch", ip.getBytes("UTF-8"));
	}
}
