package psc_team.psc.items;

import net.minecraft.item.Item;
import psc_team.psc.PSC;

/*
 * @author SirBlobman
 */
public class BasicItem extends Item 
{
	public BasicItem(String name)
	{
		setUnlocalizedName(name);
		setCreativeTab(PSC.PSC);
	}
}
