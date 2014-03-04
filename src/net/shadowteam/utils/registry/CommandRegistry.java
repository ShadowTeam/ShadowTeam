package net.shadowteam.utils.registry;

import net.minecraft.command.CommandBase;

import cpw.mods.fml.common.event.FMLServerStartingEvent;

import net.shadowteam.Commands.CommandBanFix;
import net.shadowteam.Commands.CommandKillFix;
import net.shadowteam.Commands.CommandRain;
import net.shadowteam.Commands.CommandTPS;
import net.shadowteam.Commands.CommandTPX;
import net.shadowteam.utils.libs.Properties;

public final class CommandRegistry
{
    public static void init(final FMLServerStartingEvent event)
    {
        register(event, new CommandCCM());
        register(event, new CommandTPS());
        register(event, new CommandKillFix());
        register(event, new CommandBanFix());
        if (!Properties.MYSTCARFT_LOADED)
        {
            register(event, new CommandTPX());
        } else
        {
            CommandCCM.registerSub(new CommandTPX());
        }
        CommandCCM.registerSub(new CommandRain());
    }

    static void register(final FMLServerStartingEvent event, final CommandBase cmd)
    {
        event.registerServerCommand(cmd);
    }
}