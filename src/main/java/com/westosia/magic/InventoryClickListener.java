package com.westosia.magic;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class InventoryClickListener implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        Player player = (Player) e.getWhoClicked();
        if (e.getView().getCursor() != null && e.getView().getCursor().getType() == Material.BOOK) {
            if (e.getCurrentItem() != null && e.getCurrentItem().getType() == Material.WOODEN_SWORD && e.getCurrentItem().hasItemMeta() && e.getCurrentItem().getItemMeta().getCustomModelData() >= 1 && e.getCurrentItem().getItemMeta().getCustomModelData() <= 2) {
                if (player.getItemOnCursor().hasItemMeta() && player.getItemOnCursor().getItemMeta().getCustomModelData() >= 1 && player.getItemOnCursor().getItemMeta().getCustomModelData() <= 8) {
                    ItemStack spellBook = player.getItemOnCursor();
                    ItemStack staff = e.getCurrentItem();
                    List<String> staffLore = staff.getItemMeta().getLore();
                    if (staffLore.size() == 5 && staffLore.get(2).contains("<Empty>")) {
                        if (player.getItemOnCursor().getItemMeta().getCustomModelData() == 1) {
                            staffLore.set(2, ChatColor.DARK_GRAY + "Spell = " + ChatColor.GOLD + "FireBall");
                            staff.setLore(staffLore);
                            e.setCurrentItem(staff);
                        } else if (player.getItemOnCursor().getItemMeta().getCustomModelData() == 2) {
                            staffLore.set(2, ChatColor.DARK_GRAY + "Spell = " + ChatColor.AQUA + "Magic Arrow");
                            staff.setLore(staffLore);
                            e.setCurrentItem(staff);
                        } else if (player.getItemOnCursor().getItemMeta().getCustomModelData() == 3) {
                            staffLore.set(2, ChatColor.DARK_GRAY + "Spell = " + ChatColor.DARK_GRAY + "Invisibility");
                            staff.setLore(staffLore);
                            e.setCurrentItem(staff);
                        } else if (player.getItemOnCursor().getItemMeta().getCustomModelData() == 4) {
                            staffLore.set(2, ChatColor.DARK_GRAY + "Spell = " + ChatColor.DARK_GREEN + "Earthen Wall");
                            staff.setLore(staffLore);
                            e.setCurrentItem(staff);
                        } else if (player.getItemOnCursor().getItemMeta().getCustomModelData() == 5) {
                            staffLore.set(2, ChatColor.DARK_GRAY + "Spell = " + ChatColor.GOLD + "Greater FireBall");
                            staff.setLore(staffLore);
                            e.setCurrentItem(staff);
                        } else if (player.getItemOnCursor().getItemMeta().getCustomModelData() == 6) {
                            staffLore.set(2, ChatColor.DARK_GRAY + "Spell = " + ChatColor.AQUA + "Infinite Magic Arrows");
                            staff.setLore(staffLore);
                            e.setCurrentItem(staff);
                        } else if (player.getItemOnCursor().getItemMeta().getCustomModelData() == 7) {
                            staffLore.set(2, ChatColor.DARK_GRAY + "Spell = " + ChatColor.DARK_GRAY + "Greater Invisibility");
                            staff.setLore(staffLore);
                            e.setCurrentItem(staff);
                        } else if (player.getItemOnCursor().getItemMeta().getCustomModelData() == 8) {
                            staffLore.set(2, ChatColor.DARK_GRAY + "Spell = " + ChatColor.DARK_GREEN + "Mountainous Wall");
                            staff.setLore(staffLore);
                            e.setCurrentItem(staff);
                        }
                    }
                }

            }

        }
    }
}
