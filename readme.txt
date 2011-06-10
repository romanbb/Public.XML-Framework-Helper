**Usage**
=========

	java -jar framework_helper.jar [path to public xml file] [# of battery images] [# of charging images] [optional file to pull custom strings from]

Explanation
-----------
`[# of battery images]` - usually you guys are going to have this at 100, it's the TOTAL number of images for percentage (some may want to have it at 20, but i left it flexible)

`[# of charging images]` - however many you want, 20 for 5% increments, or maybe just 100. note: it starts at 0, so if you want 100 charging images, the last one should be named 99. please ask if you need clarification on this.

`[optional file to pull custom strings from]` - if you are someone like Whitehawkx and does mods constantly, this may be of use, besides the battery images, it can add more resource IDs for whatever you might want.

to use this, just simply put in a text file and input the text file. for example:

Say I have a file called custom.txt, in the file are the following: 

> `hawk_reboot`   
> `hawk_recovery`  
> `hawk_download`  

Then here are my inputs:
>java -jar framework_helper.jar public.xml 100 20 custom.txt[/CODE]

The following is [I]ADDED [/I]to your existing public.xml with PROPER resource Ids and in theproper location (the program does extensive checking to make sure no ids are duplicated :))

	<public type="drawable" name="hawk_reboot" id="0x01080404" />
	<public type="drawable" name="hawk_recovery" id="0x01080405" />
	<public type="drawable" name="hawk_download" id="0x01080406" />
	<public type="drawable" name="stat_sys_battery_1" id="0x01080423" />
	<public type="drawable" name="stat_sys_battery_2" id="0x01080424" />
	<public type="drawable" name="stat_sys_battery_3" id="0x01080425" />
	<public type="drawable" name="stat_sys_battery_4" id="0x01080426" />
	<public type="drawable" name="stat_sys_battery_5" id="0x01080427" />
	<public type="drawable" name="stat_sys_battery_6" id="0x01080428" />
	<public type="drawable" name="stat_sys_battery_7" id="0x01080429" />
	<public type="drawable" name="stat_sys_battery_8" id="0x0108042a" />
	<public type="drawable" name="stat_sys_battery_9" id="0x0108042b" />
	<public type="drawable" name="stat_sys_battery_11" id="0x0108042c" />
	<public type="drawable" name="stat_sys_battery_12" id="0x0108042d" />
	<public type="drawable" name="stat_sys_battery_13" id="0x0108042e" />
	<public type="drawable" name="stat_sys_battery_14" id="0x0108042f" />
	<public type="drawable" name="stat_sys_battery_15" id="0x01080430" />
	<public type="drawable" name="stat_sys_battery_16" id="0x01080431" />
	<public type="drawable" name="stat_sys_battery_17" id="0x01080432" />
	<public type="drawable" name="stat_sys_battery_18" id="0x01080433" />
	<public type="drawable" name="stat_sys_battery_19" id="0x01080434" />
	<public type="drawable" name="stat_sys_battery_21" id="0x01080435" />
	<public type="drawable" name="stat_sys_battery_22" id="0x01080436" />
	<public type="drawable" name="stat_sys_battery_23" id="0x01080437" />
	<public type="drawable" name="stat_sys_battery_24" id="0x01080438" />
	<public type="drawable" name="stat_sys_battery_25" id="0x01080439" />
	<public type="drawable" name="stat_sys_battery_26" id="0x0108043a" />
	<public type="drawable" name="stat_sys_battery_27" id="0x0108043b" />
	<public type="drawable" name="stat_sys_battery_28" id="0x0108043c" />
	<public type="drawable" name="stat_sys_battery_29" id="0x0108043d" />
	<public type="drawable" name="stat_sys_battery_30" id="0x0108043e" />
	<public type="drawable" name="stat_sys_battery_31" id="0x0108043f" />
	<public type="drawable" name="stat_sys_battery_32" id="0x01080440" />
	<public type="drawable" name="stat_sys_battery_33" id="0x01080441" />
	<public type="drawable" name="stat_sys_battery_34" id="0x01080442" />
	<public type="drawable" name="stat_sys_battery_35" id="0x01080443" />
	<public type="drawable" name="stat_sys_battery_36" id="0x01080444" />
	<public type="drawable" name="stat_sys_battery_37" id="0x01080445" />
	<public type="drawable" name="stat_sys_battery_38" id="0x01080446" />
	<public type="drawable" name="stat_sys_battery_39" id="0x01080447" />
	<public type="drawable" name="stat_sys_battery_41" id="0x01080448" />
	<public type="drawable" name="stat_sys_battery_42" id="0x01080449" />
	<public type="drawable" name="stat_sys_battery_43" id="0x0108044a" />
	<public type="drawable" name="stat_sys_battery_44" id="0x0108044b" />
	<public type="drawable" name="stat_sys_battery_45" id="0x0108044c" />
	<public type="drawable" name="stat_sys_battery_46" id="0x0108044d" />
	<public type="drawable" name="stat_sys_battery_47" id="0x0108044e" />
	<public type="drawable" name="stat_sys_battery_48" id="0x0108044f" />
	<public type="drawable" name="stat_sys_battery_49" id="0x01080450" />
	<public type="drawable" name="stat_sys_battery_50" id="0x01080451" />
	<public type="drawable" name="stat_sys_battery_51" id="0x01080452" />
	<public type="drawable" name="stat_sys_battery_52" id="0x01080453" />
	<public type="drawable" name="stat_sys_battery_53" id="0x01080454" />
	<public type="drawable" name="stat_sys_battery_54" id="0x01080455" />
	<public type="drawable" name="stat_sys_battery_55" id="0x01080456" />
	<public type="drawable" name="stat_sys_battery_56" id="0x01080457" />
	<public type="drawable" name="stat_sys_battery_57" id="0x01080458" />
	<public type="drawable" name="stat_sys_battery_58" id="0x01080459" />
	<public type="drawable" name="stat_sys_battery_59" id="0x0108045a" />
	<public type="drawable" name="stat_sys_battery_61" id="0x0108045b" />
	<public type="drawable" name="stat_sys_battery_62" id="0x0108045c" />
	<public type="drawable" name="stat_sys_battery_63" id="0x0108045d" />
	<public type="drawable" name="stat_sys_battery_64" id="0x0108045e" />
	<public type="drawable" name="stat_sys_battery_65" id="0x0108045f" />
	<public type="drawable" name="stat_sys_battery_66" id="0x01080460" />
	<public type="drawable" name="stat_sys_battery_67" id="0x01080461" />
	<public type="drawable" name="stat_sys_battery_68" id="0x01080462" />
	<public type="drawable" name="stat_sys_battery_69" id="0x01080463" />
	<public type="drawable" name="stat_sys_battery_70" id="0x01080464" />
	<public type="drawable" name="stat_sys_battery_71" id="0x01080465" />
	<public type="drawable" name="stat_sys_battery_72" id="0x01080466" />
	<public type="drawable" name="stat_sys_battery_73" id="0x01080467" />
	<public type="drawable" name="stat_sys_battery_74" id="0x01080468" />
	<public type="drawable" name="stat_sys_battery_75" id="0x01080469" />
	<public type="drawable" name="stat_sys_battery_76" id="0x0108046a" />
	<public type="drawable" name="stat_sys_battery_77" id="0x0108046b" />
	<public type="drawable" name="stat_sys_battery_78" id="0x0108046c" />
	<public type="drawable" name="stat_sys_battery_79" id="0x0108046d" />
	<public type="drawable" name="stat_sys_battery_81" id="0x0108046e" />
	<public type="drawable" name="stat_sys_battery_82" id="0x0108046f" />
	<public type="drawable" name="stat_sys_battery_83" id="0x01080470" />
	<public type="drawable" name="stat_sys_battery_84" id="0x01080471" />
	<public type="drawable" name="stat_sys_battery_85" id="0x01080472" />
	<public type="drawable" name="stat_sys_battery_86" id="0x01080473" />
	<public type="drawable" name="stat_sys_battery_87" id="0x01080474" />
	<public type="drawable" name="stat_sys_battery_88" id="0x01080475" />
	<public type="drawable" name="stat_sys_battery_89" id="0x01080476" />
	<public type="drawable" name="stat_sys_battery_90" id="0x01080477" />
	<public type="drawable" name="stat_sys_battery_91" id="0x01080478" />
	<public type="drawable" name="stat_sys_battery_92" id="0x01080479" />
	<public type="drawable" name="stat_sys_battery_93" id="0x0108047a" />
	<public type="drawable" name="stat_sys_battery_94" id="0x0108047b" />
	<public type="drawable" name="stat_sys_battery_95" id="0x0108047c" />
	<public type="drawable" name="stat_sys_battery_96" id="0x0108047d" />
	<public type="drawable" name="stat_sys_battery_97" id="0x0108047e" />
	<public type="drawable" name="stat_sys_battery_98" id="0x0108047f" />
	<public type="drawable" name="stat_sys_battery_99" id="0x01080480" />
	<public type="drawable" name="stat_sys_battery_charge_anim6" id="0x01080481" />
	<public type="drawable" name="stat_sys_battery_charge_anim7" id="0x01080482" />
	<public type="drawable" name="stat_sys_battery_charge_anim8" id="0x01080483" />
	<public type="drawable" name="stat_sys_battery_charge_anim9" id="0x01080484" />
	<public type="drawable" name="stat_sys_battery_charge_anim10" id="0x01080485" />
	<public type="drawable" name="stat_sys_battery_charge_anim11" id="0x01080486" />
	<public type="drawable" name="stat_sys_battery_charge_anim12" id="0x01080487" />
	<public type="drawable" name="stat_sys_battery_charge_anim13" id="0x01080488" />
	<public type="drawable" name="stat_sys_battery_charge_anim14" id="0x01080489" />
	<public type="drawable" name="stat_sys_battery_charge_anim15" id="0x0108048a" />
	<public type="drawable" name="stat_sys_battery_charge_anim16" id="0x0108048b" />
	<public type="drawable" name="stat_sys_battery_charge_anim17" id="0x0108048c" />
	<public type="drawable" name="stat_sys_battery_charge_anim18" id="0x0108048d" />
	<public type="drawable" name="stat_sys_battery_charge_anim19" id="0x0108048e" />

I can also do 
		java -jar framework_helper.jar public.xml 100 20

And it will just add the battery mod.


Notes
-----
-If you try and add something that already exists, the program will skip it properly. for instance stat_sys_battery_20 40 60 80 will not get added because it already exists in the public xml.
-In the future, I will try and have it generate a stat_sys_battery and a stat_sys_battery_charge automagically for you! For now, you still have to do these yourself


I'm sure that was confusing as hell, please read over and let me know if you have any questions