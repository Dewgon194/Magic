package com.westosia.magic;

import com.westosia.westosiaapi.WestosiaAPI;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

public class ClickListener implements Listener {
    private final Main instance = Main.getInstance();

    @EventHandler
    public void onClick(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        if (e.getAction() == (Action.RIGHT_CLICK_AIR) || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (e.getItem() != null && e.getItem().getType().equals(Material.WOODEN_SWORD) && e.getItem().hasItemMeta() && e.getItem().getItemMeta().getCustomModelData() >= 1 && e.getItem().getItemMeta().getCustomModelData() <= 2) {
                if (e.getItem().getLore() != null && e.getItem().getLore().get(2).contains("FireBall")) {
                    Location eyeLoc = player.getEyeLocation();
                    Location loc = player.getLocation();
                    Vector dir = loc.getDirection();
                    Location frontLoc = eyeLoc.add(dir);
                    Entity fireball = player.getWorld().spawnEntity(frontLoc, EntityType.FIREBALL);
                    fireball.setVelocity(frontLoc.getDirection().multiply(2));
                } else if (e.getItem().getLore() != null && e.getItem().getLore().get(2).contains("Magic Arrow")) {
                    Location eyeLoc = player.getEyeLocation();
                    Location loc = player.getLocation();
                    Vector dir = loc.getDirection();
                    Location frontLoc = eyeLoc.add(dir);
                    Entity fireball = player.getWorld().spawnEntity(frontLoc, EntityType.ARROW);
                    fireball.setVelocity(frontLoc.getDirection().multiply(2));
                    WestosiaAPI.getParticleEmitter().playParticle(frontLoc, Particle.BUBBLE_POP, 3);
                } else if (e.getItem().getLore() != null && e.getItem().getLore().get(2).contains("Invisibility")) {
                    player.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 10, 1));
                } else if (e.getItem().getLore() != null && e.getItem().getLore().get(2).contains("Earthen Wall")) {
                    Location eyeLoc = player.getEyeLocation();
                    Location loc = player.getLocation();
                    Vector dir = loc.getDirection();
                    Location frontLoc = eyeLoc.add(dir);
                    Block block = frontLoc.add(dir.multiply(2)).getBlock();
                    Float yaw = loc.getYaw();
                    if (yaw >= 315 && yaw <= 45) {
                        Block rightBlock = block.getLocation().add(2, 0, 0).getBlock();
                        for (double i = 0; i < 5; i++) {
                            Location tempBlock = rightBlock.getLocation().add(-i, 0, 0);
                            if (tempBlock.getBlock().getType() == Material.AIR) {
                                tempBlock.getBlock().setType(Material.DIRT);
                                air(tempBlock);
                                if (tempBlock.add(0, 1, 0).getBlock().getType() == Material.AIR) {
                                    tempBlock.getBlock().setType(Material.DIRT);
                                    air(tempBlock);
                                }

                            }

                        }


                    } else if (yaw > -135 && yaw <= -45) {
                        Block rightBlock = block.getLocation().add(0, 0, 2).getBlock();
                        player.sendMessage("1");
                        for (double i = 0; i < 5; i++) {
                            Location tempBlock = rightBlock.getLocation().add(0, 0, -i);
                            if (tempBlock.getBlock().getType() == Material.AIR) {
                                tempBlock.getBlock().setType(Material.DIRT);
                                air(tempBlock);
                                if (tempBlock.add(0, 1, 0).getBlock().getType() == Material.AIR) {
                                    tempBlock.getBlock().setType(Material.DIRT);
                                    air(tempBlock);
                                }

                            }

                        }
                    } else if (yaw > -45 && yaw <= 45) {
                        Block rightBlock = block.getLocation().add(-2, 0, 0).getBlock();
                        for (double i = 0; i < 5; i++) {
                            Location tempBlock = rightBlock.getLocation().add(i, 0, 0);
                            if (tempBlock.getBlock().getType() == Material.AIR) {
                                tempBlock.getBlock().setType(Material.DIRT);
                                air(tempBlock);
                                if (tempBlock.add(0, 1, 0).getBlock().getType() == Material.AIR) {
                                    tempBlock.getBlock().setType(Material.DIRT);
                                    air(tempBlock);
                                }

                            }

                        }
                    } else if (yaw > -45 && yaw < 45) {
                        Block rightBlock = block.getLocation().add(0, 0, -2).getBlock();
                        for (double i = 0; i < 5; i++) {
                            Location tempBlock = rightBlock.getLocation().add(0, 0, i);
                            if (tempBlock.getBlock().getType() == Material.AIR) {
                                tempBlock.getBlock().setType(Material.DIRT);
                                air(tempBlock);
                                if (tempBlock.add(0, 1, 0).getBlock().getType() == Material.AIR) {
                                    tempBlock.getBlock().setType(Material.DIRT);
                                    air(tempBlock);
                                }

                            }

                        }
                    }
                } else if (e.getItem().getLore() != null && e.getItem().getLore().get(2).contains("Greater Fireball")) {
                    Location eyeLoc = player.getEyeLocation();
                    Location loc = player.getLocation();
                    Vector dir = loc.getDirection();
                    Location frontLoc = eyeLoc.add(dir);
                    Entity dgfireball = player.getWorld().spawnEntity(frontLoc, EntityType.DRAGON_FIREBALL);
                    dgfireball.setVelocity(frontLoc.getDirection().multiply(2));
                } else if (e.getItem().getLore() != null && e.getItem().getLore().get(2).contains("Infinite Magic Arrows")) {
                    Location eyeLoc = player.getEyeLocation();
                    Location loc = player.getLocation();
                    Vector dir = loc.getDirection();
                    Location frontLoc = eyeLoc.add(dir);
                    Entity arrow = player.getWorld().spawnEntity(frontLoc, EntityType.ARROW);
                    Entity arrow2 = player.getWorld().spawnEntity(frontLoc.add(0, 0.2, 0), EntityType.ARROW);
                    Entity arrow3 = player.getWorld().spawnEntity(frontLoc.add(0, 0.4, 0), EntityType.ARROW);
                    arrow.setVelocity(frontLoc.getDirection().multiply(2));
                    arrow2.setVelocity(frontLoc.getDirection().multiply(2));
                    arrow3.setVelocity(frontLoc.getDirection().multiply(2));
                    WestosiaAPI.getParticleEmitter().playParticle(frontLoc, Particle.BUBBLE_POP, 3);
                } else if (e.getItem().getLore() != null && e.getItem().getLore().get(2).contains("Greater Invisibility")) {
                    player.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 30, 1));
                } else if (e.getItem().getLore() != null && e.getItem().getLore().get(2).contains("Mountainous Wall")) {
                    Location eyeLoc = player.getEyeLocation();
                    Location loc = player.getLocation();
                    Vector dir = loc.getDirection();
                    Location frontLoc = eyeLoc.add(dir);
                    Block block = frontLoc.add(dir.multiply(2)).getBlock();
                    Float yaw = loc.getYaw();
                    if (yaw >= 135 || yaw <= -135) {
                        Block rightBlock = block.getLocation().add(2, 0, 0).getBlock();
                        for (double i = 0; i < 5; i++) {
                            Location tempBlock = rightBlock.getLocation().add(-i, 0, 0);
                            if (tempBlock.getBlock().getType() == Material.AIR) {
                                tempBlock.getBlock().setType(Material.STONE);
                                air(tempBlock);
                                if (tempBlock.add(0, 1, 0).getBlock().getType() == Material.AIR) {
                                    tempBlock.getBlock().setType(Material.STONE);
                                    air(tempBlock);
                                    if (tempBlock.add(0, 1, 0).getBlock().getType() == Material.AIR) {
                                        tempBlock.getBlock().setType(Material.STONE);
                                        air(tempBlock);
                                    }

                                }

                            }


                        }
                    } else if (yaw > -135 || yaw <= -45) {
                        Block rightBlock = block.getLocation().add(0, 0, 2).getBlock();
                        for (double i = 0; i < 5; i++) {
                            Location tempBlock = rightBlock.getLocation().add(0, 0, -i);
                            if (tempBlock.getBlock().getType() == Material.AIR) {
                                tempBlock.getBlock().setType(Material.STONE);
                                air(tempBlock);
                                if (tempBlock.add(0, 1, 0).getBlock().getType() == Material.AIR) {
                                    tempBlock.getBlock().setType(Material.STONE);
                                    air(tempBlock);
                                    if (tempBlock.add(0, 1, 0).getBlock().getType() == Material.AIR) {
                                        tempBlock.getBlock().setType(Material.STONE);
                                        air(tempBlock);
                                    }

                                }

                            }

                        }
                    } else if (yaw > 45 || yaw <= 135) {
                        Block rightBlock = block.getLocation().add(-2, 0, 0).getBlock();
                        for (double i = 0; i < 5; i++) {
                            Location tempBlock = rightBlock.getLocation().add(i, 0, 0);
                            if (tempBlock.getBlock().getType() == Material.AIR) {
                                tempBlock.getBlock().setType(Material.STONE);
                                air(tempBlock);
                                if (tempBlock.add(0, 1, 0).getBlock().getType() == Material.AIR) {
                                    tempBlock.getBlock().setType(Material.STONE);
                                    air(tempBlock);
                                    if (tempBlock.add(0, 1, 0).getBlock().getType() == Material.AIR) {
                                        tempBlock.getBlock().setType(Material.STONE);
                                        air(tempBlock);
                                    }

                                }

                            }

                        }
                    } else if (yaw > -45 || yaw < 45) {
                        Block rightBlock = block.getLocation().add(0, 0, -2).getBlock();
                        for (double i = 0; i < 5; i++) {
                            Location tempBlock = rightBlock.getLocation().add(0, 0, i);
                            if (tempBlock.getBlock().getType() == Material.AIR) {
                                tempBlock.getBlock().setType(Material.STONE);
                                air(tempBlock);
                                if (tempBlock.add(0, 1, 0).getBlock().getType() == Material.AIR) {
                                    tempBlock.getBlock().setType(Material.STONE);
                                    air(tempBlock);
                                    if (tempBlock.add(0, 1, 0).getBlock().getType() == Material.AIR) {
                                        tempBlock.getBlock().setType(Material.STONE);
                                        air(tempBlock);
                                    }

                                }

                            }

                        }
                    }
                }

            }

        }
    }

    public void air(Location locBlock) {
        Bukkit.getScheduler().runTaskLater(instance, () -> {
            locBlock.getBlock().setType(Material.AIR);
        }, 20 * 5);
    }
}
