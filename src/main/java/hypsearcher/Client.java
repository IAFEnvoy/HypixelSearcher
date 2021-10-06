package hypsearcher;

import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import hypsearcher.hypixel.GetJSON;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.command.v1.ClientCommandManager;
import net.fabricmc.fabric.api.client.command.v1.FabricClientCommandSource;

@Environment(EnvType.CLIENT)
public class Client implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		GetJSON.overview("IAFEnvoy", null, 3);
		ClientCommandManager.DISPATCHER.register(ClientCommandManager.literal("Hypixel")
				.then(ClientCommandManager.argument("PlayerName", StringArgumentType.word())
						.then(ClientCommandManager.literal("Overview").executes(Client::getOverview))
						.then(ClientCommandManager.literal("Bedwar").executes(Client::getBedwar))
						.then(ClientCommandManager.literal("Skywar").executes(Client::getSkywar))
						.then(ClientCommandManager.literal("BuildBattle").executes(Client::getBuildBattle))));
	}

	private static int getOverview(CommandContext<FabricClientCommandSource> context) {
		Thread thread = new Thread() {
			public void run() {
				GetJSON.overview(StringArgumentType.getString(context, "PlayerName"), context.getSource().getPlayer(),
						0);
			}
		};
		thread.start();
		return 0;
	}

	private static int getBedwar(CommandContext<FabricClientCommandSource> context) {
		Thread thread = new Thread() {
			public void run() {
				GetJSON.overview(StringArgumentType.getString(context, "PlayerName"), context.getSource().getPlayer(),
						1);
			}
		};
		thread.start();
		return 0;
	}

	private static int getSkywar(CommandContext<FabricClientCommandSource> context) {
		Thread thread = new Thread() {
			public void run() {
				GetJSON.overview(StringArgumentType.getString(context, "PlayerName"), context.getSource().getPlayer(),
						2);
			}
		};
		thread.start();
		return 0;
	}

	private static int getBuildBattle(CommandContext<FabricClientCommandSource> context) {
		Thread thread = new Thread() {
			public void run() {
				GetJSON.overview(StringArgumentType.getString(context, "PlayerName"), context.getSource().getPlayer(),
						3);
			}
		};
		thread.start();
		return 0;
	}
}
