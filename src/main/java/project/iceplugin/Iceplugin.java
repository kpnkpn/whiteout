package project.iceplugin;



import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerEggThrowEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitScheduler;
import java.util.HashMap;
import java.util.UUID;
import java.util.function.Function;
//바람이 귀엽게 부는 곳은? 분당 엌ㅋㅋ

public final class Iceplugin extends JavaPlugin implements Listener {

    private final HashMap<UUID, Integer> playerGlobalVars = new HashMap<>();//hash map(뭔지는 모름 gpt가 짜줌)

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



    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        UUID playerUUID = player.getUniqueId();

        // 플레이어가 처음 접속했을 때 전역 변수를 초기화
        if (!playerGlobalVars.containsKey(playerUUID)) {
            playerGlobalVars.put(playerUUID, 0); // 초기값을 0으로 설정
        }

        // 현재 플레이어의 전역 변수 값을 가져와서 메시지로 전송
        int playerVar = playerGlobalVars.get(playerUUID);
        player.sendMessage("당신의 전역 변수 값은: " + playerVar);
    }
    // 플레이어 전역 변수 값을 업데이트하는 메서드
    public void setPlayerGlobalVar(Player player, int value) {
        UUID playerUUID = player.getUniqueId();
        playerGlobalVars.put(playerUUID, value);
        player.sendMessage("당신의 전역 변수 값이 " + value + "(으)로 설정되었습니다.");
    }

    // 플레이어 전역 변수 값을 가져오는 메서드
    public int getPlayerGlobalVar(Player player) {
        UUID playerUUID = player.getUniqueId();
        return playerGlobalVars.getOrDefault(playerUUID, 0);

    }
    public void addPlayerGlobalVar(Player player, int value) {
        UUID playerUUID = player.getUniqueId();
        int currentValue = playerGlobalVars.getOrDefault(playerUUID, 0);
        int newValue = currentValue + value;
        playerGlobalVars.put(playerUUID, newValue);
        player.sendMessage("당신의 전역 변수 값이 " + value + "만큼 증가하여 " + newValue + "이(가) 되었습니다.");
    }

    public void getPlayerGlobalVar(PlayerJoinEvent a, Player player, int value){
        Player p = a.getPlayer();
        UUID playerUUID = player.getUniqueId();
        try {
            addPlayerGlobalVar(player, 1);
        }catch (NumberFormatException e) {
            player.sendMessage("숫자를 입력해주세요!");}
        addPlayerGlobalVar(player, 1);
        a.setJoinMessage("[ " +p.getName()+" ]"+ ChatColor.GREEN + " 님이 화이트아웃서버에 접속하였습니다");

    }
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;

            if (command.getName().equalsIgnoreCase("addvar")) {
                if (args.length > 0) {
                    try {
                        int value = Integer.parseInt(args[0]);
                        addPlayerGlobalVar(player, value);
                        return true;
                    } catch (NumberFormatException e) {
                        player.sendMessage("숫자를 입력해주세요!");
                    }
                } else {
                    player.sendMessage("값을 입력해주세요!");
                }
            }
        }
        return false;
    }


}




