package psc_team.psc.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import psc_team.psc.PSC;
import psc_team.psc.container.ContainerDehydrator;
import psc_team.psc.entity.tile.TileEntityDehydrator;

/**
 * @author The_Fireplace
 */
public class GuiDehydrator extends GuiContainer {
	public static final ResourceLocation texture = new ResourceLocation(PSC.MODID, "textures/gui/dehydrator.png");
	private TileEntityDehydrator te;

	public GuiDehydrator(InventoryPlayer invPlayer, TileEntityDehydrator entity) {
		super(new ContainerDehydrator(invPlayer, entity));
		xSize = 176;
		ySize = 143;
		ScaledResolution res = new ScaledResolution(Minecraft.getMinecraft());
		width = res.getScaledWidth();
		height = res.getScaledHeight();
		guiLeft = (width - xSize) / 2;
		guiTop = (height - ySize) / 2;
		te=entity;
	}

	@Override
	public void initGui(){
		ScaledResolution res = new ScaledResolution(Minecraft.getMinecraft());
		width = res.getScaledWidth();
		height = res.getScaledHeight();
		guiLeft = (width - xSize) / 2;
		guiTop = (height - ySize) / 2;
		super.initGui();
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		GL11.glColor4f(1F, 1F, 1F, 1F);
		Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
		int k = (this.width - this.xSize) / 2;
		int l = (this.height - this.ySize) / 2;
		this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
	}
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY){
		this.fontRendererObj.drawString(String.valueOf(te.getStoredFuel()), 8+18, 26-5, 16777215);
	}
}