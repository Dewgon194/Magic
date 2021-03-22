package com.westosia.magic;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import java.util.List;

public class InventoryClickListener implements Listener {

    public void setLore(List<String> lore, ItemStack item, String spellType) {
        lore.set(2, ChatColor.DARK_GRAY + "Spell = " + spellType);
        item.setLore(lore);


    }

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        Player player = (Player) e.getWhoClicked();
        if (e.getView().getCursor() != null && e.getView().getCursor().getType() == Material.BOOK) {
            if (e.getCurrentItem() != null && e.getCurrentItem().getType() == Material.WOODEN_SWORD && e.getCurrentItem().hasItemMeta() && e.getCurrentItem().getItemMeta().getCustomModelData() >= 1 && e.getCurrentItem().getItemMeta().getCustomModelData() <= 2) {
                if (player.getItemOnCursor().hasItemMeta() && player.getItemOnCursor().getItemMeta().getCustomModelData() >= 1 && player.getItemOnCursor().getItemMeta().getCustomModelData() <= 8) {
                    int spellBookModel = player.getItemOnCursor().getItemMeta().getCustomModelData();
                    ItemStack staff = e.getCurrentItem();
                    List<String> staffLore = staff.getItemMeta().getLore();
                    if (staffLore.size() == 5 && staffLore.get(2).contains("<Empty>")) {
                        if (spellBookModel == 1) {
                            String spellType = (ChatColor.GOLD + "FireBall");
                            setLore(staffLore, staff, spellType);
                            e.setCurrentItem(staff);
                        } else if (spellBookModel == 2) {
                            String spellType = (ChatColor.AQUA + "Magic Arrow");
                            setLore(staffLore, staff, spellType);
                            e.setCurrentItem(staff);
                        } else if (spellBookModel == 3) {
                            String spellType = (ChatColor.DARK_GRAY + "Invisibility");
                            setLore(staffLore, staff, spellType);
                            e.setCurrentItem(staff);
                        } else if (spellBookModel == 4) {
                            String spellType = (ChatColor.DARK_GREEN + "Earthen Wall");
                            staffLore.set(2, ChatColor.DARK_GRAY + "Spell = " + ChatColor.DARK_GREEN + "Earthen Wall");
                            staff.setLore(staffLore);
                            e.setCurrentItem(staff);
                        } else if (spellBookModel == 5) {
                            String spellType = (ChatColor.GOLD + "Greater FireBall");
                            setLore(staffLore, staff, spellType);
                            e.setCurrentItem(staff);
                        } else if (spellBookModel == 6) {
                            String spellType = (ChatColor.AQUA + "Infinite Magic Arrows");
                            setLore(staffLore, staff, spellType);
                            e.setCurrentItem(staff);
                        } else if (spellBookModel == 7) {
                            String spellType = (ChatColor.DARK_GRAY + "Greater Invisibility");
                            setLore(staffLore, staff, spellType);
                            e.setCurrentItem(staff);
                        } else if (spellBookModel == 8) {
                            String spellType = (ChatColor.DARK_GREEN + "Mountainous Wall");
                            setLore(staffLore, staff, spellType);
                            e.setCurrentItem(staff);
                        }
                    }
                }

            }

        }
    }
}
