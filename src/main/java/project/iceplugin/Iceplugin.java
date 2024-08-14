package project.iceplugin;



import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerEggThrowEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitScheduler;

import java.util.function.Function;
//바람이 귀엽게 부는 곳은? 우왕좌왕 엌ㅋzzzzzzZ

public final class Iceplugin extends JavaPlugin implements Listener {
    boolean blind = false;
    int random = (int)0;
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
        BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
        scheduler.scheduleSyncRepeatingTask(this, new Runnable() {

            public void run() {
                for(World world : Bukkit.getWorlds()){
                    if(world.getTime() == 3000) {
                        random = 5;
                        blind = false;
                        random = (int)(Math.random()*3)+1;
                        getServer().broadcastMessage(String.valueOf(random));
                    }
                    if(world.getTime() == 6000) {
                        random = 5;
                        blind = false;
                        random = (int)(Math.random()*3)+1;
                        getServer().broadcastMessage(String.valueOf(random));
                    }
                    if(world.getTime() == 9000) {
                        random = 5;
                        blind = false;
                        random = (int)(Math.random()*3)+1;
                        getServer().broadcastMessage(String.valueOf(random));
                    }
                    if(world.getTime() == 12000) {
                        random = 5;
                        blind = false;
                        random = (int)(Math.random()*3)+1;
                        getServer().broadcastMessage(String.valueOf(random));
                    }
                    if(world.getTime() == 15000) {
                        random = 5;
                        blind = false;
                        random = (int)(Math.random()*3)+1;
                        getServer().broadcastMessage(String.valueOf(random));
                    }
                    if(world.getTime() == 18000) {
                        random = 5;
                        blind = false;
                        random = (int)(Math.random()*3)+1;
                        getServer().broadcastMessage(String.valueOf(random));
                    }
                    if(world.getTime() == 21000) {
                        random = 5;
                        blind = false;
                        random = (int)(Math.random()*3)+1;
                        getServer().broadcastMessage(String.valueOf(random));
                    }
                    if(world.getTime() == 24000) {
                        random = 5;
                        blind = false;
                        random = (int)(Math.random()*3)+1;
                        getServer().broadcastMessage(String.valueOf(random));
                    }

                if(blind == true){
                    for(Player all : Bukkit.getOnlinePlayers()){
                        all.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS , 50/*지속시간*/, 1 /*레벨*/, false /*증푝*/, false /*파티클 보일것인가*/, false /*아이콘을 보일것인가*/));
                    }
                }



                }
                switch (random){//날씨 이벤트
                case 1:
                    blind = true;
                    break;
                }
            }
        }, 1, 1);



}







}




