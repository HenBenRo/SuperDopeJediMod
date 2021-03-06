package superdopesquad.superdopejedimod;

import java.util.Set;
import java.util.HashSet;

import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
//import net.minecraftforge.fml.common.Mod.Instance;
//import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;


@Mod(modid=SuperDopeJediMod.MODID, name=SuperDopeJediMod.MODNAME, version=SuperDopeJediMod.MODVER) //Tell forge "Oh hey, there's a new mod here to load."
public class SuperDopeJediMod //Start the class Declaration
{
    // Set the metadata of the mod.
    public static final String MODID = "superdopejedimod";
    public static final String MODNAME = "SuperDopeJediMod";
    public static final String MODVER = "0.0.1";

    // This is the collection of custom objects we will maintain.
    public static Set<SuperDopeObject> customObjects = new HashSet<SuperDopeObject>();
    
    // instance variable.
    //@Instance(value = SuperDopeJediMod.MODID) //Tell Forge what instance to use.
    //public static SuperDopeJediMod instance;
    
    // Custom blocks items.
    public static BaseItem gaffiStick = new GaffiStick("gaffiStick");  
    public static BaseBlock brownSteel = new BrownSteel("brownSteel");
    public static BaseItem brownSteelIngot = new BrownSteelIngot("brownSteelIngot");    
    public static BaseBlock brownSteelOre = new BrownSteelOre("brownSteelOre");
    public static BaseBlock vehicleSeat = new VehicleSeat("vehicleSeat");
    public static BaseItemFood nourishmentCapsule = new NourishmentCapsule("nourishmentCapsule");
    public static BaseItem lightSaberRed = new LightSaber("lightSaberRed", "Red"); 
    public static BaseItem lightSaberBlue = new LightSaber("lightSaberBlue", "Blue");
    public static BaseItem lightSaberGreen = new LightSaber("lightSaberGreen", "Green");
    public static BaseItem lightSaberPurple = new LightSaber("lightSaberPurple", "Purple");
    public static BaseItem doubleLightSaberRed = new DoubleLightSaber("doubleLightSaberRed", "Red");
    public static BaseItem doubleLightSaberBlue = new DoubleLightSaber("doubleLightSaberBlue", "Blue");
    public static BaseItem doubleLightSaberGreen = new DoubleLightSaber("doubleLightSaberGreen", "Green");
    public static BaseItem doubleLightSaberPurple = new DoubleLightSaber("doubleLightSaberPurple", "Purple");
    public static BaseItem redPowerCrystal = new PowerCrystal("redPowerCrystal", "Red");
    public static BaseItem bluePowerCrystal = new PowerCrystal("bluePowerCrystal", "Blue");
    public static BaseItem greenPowerCrystal = new PowerCrystal("greenPowerCrystal", "Green");
    public static BaseItem purplePowerCrystal = new PowerCrystal("purplePowerCrystal", "Purple");
    public static BaseBlock redPowerCrystalOre = new PowerCrystalOre("redPowerCrystalOre", "Red");
    public static BaseBlock bluePowerCrystalOre = new PowerCrystalOre("bluePowerCrystalOre", "Blue");
    public static BaseBlock greenPowerCrystalOre = new PowerCrystalOre("greenPowerCrystalOre", "Green");
    public static BaseBlock purplePowerCrystalOre = new PowerCrystalOre("purplePowerCrystalOre", "Purple");
    
    public static BaseItem credit = new Credit("credit"); 

    //@SidedProxy(clientSide="tutorial.generic.client.ClientProxy",
    //        serverSide="tutorial.generic.CommonProxy")
    
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
    	   	
    	// Iterate through all our custom blocks and items, and
    	// register them all.
    	for (SuperDopeObject superDopeObject : this.customObjects) {
    		superDopeObject.registerObject();
    	}
    }
     
     
    
    @EventHandler
    public void load(FMLInitializationEvent event) {
    }
      
    
    @EventHandler
    public void init(FMLInitializationEvent event) {
    	
    	// Iterate through all our custom blocks and items, 
    	// and see if we have any recipes to register.
    	for (SuperDopeObject superDopeObject : this.customObjects) {
    		superDopeObject.registerRecipe();
    	}
    	
    	// All model and texture rendering has to be client-side only.
    	if(event.getSide() == Side.CLIENT) {
    	     
    		// Iterate through all our custom objects, and
        	// see if we have any models to render.
        	for (SuperDopeObject superDopeObject : this.customObjects) {
        		superDopeObject.registerModel();
        	}
    	}
    }
    
 
    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
    }
    
}

