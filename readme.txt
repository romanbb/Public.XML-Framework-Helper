<h1><strong>Usage</strong></h1>

<p><code>java -jar framework_helper.jar [path to public xml file] [# of battery images] [# of charging images] [optional file to pull custom strings from]</code></p>

<h2>Explanation</h2>

<p><code>[# of battery images]</code> - usually you guys are going to have this at 100, it's the TOTAL number of images for percentage (some may want to have it at 20, but i left it flexible)</p>

<p><code>[# of charging images]</code> - however many you want, 20 for 5% increments, or maybe just 100. note: it starts at 0, so if you want 100 charging images, the last one should be named 99. please ask if you need clarification on this.</p>

<p><code>[optional file to pull custom strings from]</code> - if you are someone like Whitehawkx and does mods constantly, this may be of use, besides the battery images, it can add more resource IDs for whatever you might want.</p>

<p>to use this, just simply put in a text file and input the text file. for example:</p>

<p>Say I have a file called custom.txt, in the file are the following: </p>

<blockquote>
  <p><code>hawk_reboot</code> <br />
<code>hawk_recovery</code> <br />
<code>hawk_download</code>  </p>
</blockquote>

<p>Then here are my inputs:</p>

<blockquote>
  <p>java -jar framework_helper.jar public.xml 100 20 custom.txt[/CODE]</p>
</blockquote>

<p>The following is [I]ADDED [/I]to your existing public.xml with PROPER resource Ids and in theproper location (the program does extensive checking to make sure no ids are duplicated :))</p>

<pre><code>&lt;public type="drawable" name="hawk_reboot" id="0x01080404" /&gt;
&lt;public type="drawable" name="hawk_recovery" id="0x01080405" /&gt;
&lt;public type="drawable" name="hawk_download" id="0x01080406" /&gt;
&lt;public type="drawable" name="stat_sys_battery_1" id="0x01080423" /&gt;
&lt;public type="drawable" name="stat_sys_battery_2" id="0x01080424" /&gt;
&lt;public type="drawable" name="stat_sys_battery_3" id="0x01080425" /&gt;
&lt;public type="drawable" name="stat_sys_battery_4" id="0x01080426" /&gt;
&lt;public type="drawable" name="stat_sys_battery_5" id="0x01080427" /&gt;
&lt;public type="drawable" name="stat_sys_battery_6" id="0x01080428" /&gt;
&lt;public type="drawable" name="stat_sys_battery_7" id="0x01080429" /&gt;
&lt;public type="drawable" name="stat_sys_battery_8" id="0x0108042a" /&gt;
&lt;public type="drawable" name="stat_sys_battery_9" id="0x0108042b" /&gt;
&lt;public type="drawable" name="stat_sys_battery_11" id="0x0108042c" /&gt;
&lt;public type="drawable" name="stat_sys_battery_12" id="0x0108042d" /&gt;
&lt;public type="drawable" name="stat_sys_battery_13" id="0x0108042e" /&gt;
&lt;public type="drawable" name="stat_sys_battery_14" id="0x0108042f" /&gt;
&lt;public type="drawable" name="stat_sys_battery_15" id="0x01080430" /&gt;
&lt;public type="drawable" name="stat_sys_battery_16" id="0x01080431" /&gt;
&lt;public type="drawable" name="stat_sys_battery_17" id="0x01080432" /&gt;
&lt;public type="drawable" name="stat_sys_battery_18" id="0x01080433" /&gt;
&lt;public type="drawable" name="stat_sys_battery_19" id="0x01080434" /&gt;
&lt;public type="drawable" name="stat_sys_battery_21" id="0x01080435" /&gt;
&lt;public type="drawable" name="stat_sys_battery_22" id="0x01080436" /&gt;
&lt;public type="drawable" name="stat_sys_battery_23" id="0x01080437" /&gt;
&lt;public type="drawable" name="stat_sys_battery_24" id="0x01080438" /&gt;
&lt;public type="drawable" name="stat_sys_battery_25" id="0x01080439" /&gt;
&lt;public type="drawable" name="stat_sys_battery_26" id="0x0108043a" /&gt;
&lt;public type="drawable" name="stat_sys_battery_27" id="0x0108043b" /&gt;
&lt;public type="drawable" name="stat_sys_battery_28" id="0x0108043c" /&gt;
&lt;public type="drawable" name="stat_sys_battery_29" id="0x0108043d" /&gt;
&lt;public type="drawable" name="stat_sys_battery_30" id="0x0108043e" /&gt;
&lt;public type="drawable" name="stat_sys_battery_31" id="0x0108043f" /&gt;
&lt;public type="drawable" name="stat_sys_battery_32" id="0x01080440" /&gt;
&lt;public type="drawable" name="stat_sys_battery_33" id="0x01080441" /&gt;
&lt;public type="drawable" name="stat_sys_battery_34" id="0x01080442" /&gt;
&lt;public type="drawable" name="stat_sys_battery_35" id="0x01080443" /&gt;
&lt;public type="drawable" name="stat_sys_battery_36" id="0x01080444" /&gt;
&lt;public type="drawable" name="stat_sys_battery_37" id="0x01080445" /&gt;
&lt;public type="drawable" name="stat_sys_battery_38" id="0x01080446" /&gt;
&lt;public type="drawable" name="stat_sys_battery_39" id="0x01080447" /&gt;
&lt;public type="drawable" name="stat_sys_battery_41" id="0x01080448" /&gt;
&lt;public type="drawable" name="stat_sys_battery_42" id="0x01080449" /&gt;
&lt;public type="drawable" name="stat_sys_battery_43" id="0x0108044a" /&gt;
&lt;public type="drawable" name="stat_sys_battery_44" id="0x0108044b" /&gt;
&lt;public type="drawable" name="stat_sys_battery_45" id="0x0108044c" /&gt;
&lt;public type="drawable" name="stat_sys_battery_46" id="0x0108044d" /&gt;
&lt;public type="drawable" name="stat_sys_battery_47" id="0x0108044e" /&gt;
&lt;public type="drawable" name="stat_sys_battery_48" id="0x0108044f" /&gt;
&lt;public type="drawable" name="stat_sys_battery_49" id="0x01080450" /&gt;
&lt;public type="drawable" name="stat_sys_battery_50" id="0x01080451" /&gt;
&lt;public type="drawable" name="stat_sys_battery_51" id="0x01080452" /&gt;
&lt;public type="drawable" name="stat_sys_battery_52" id="0x01080453" /&gt;
&lt;public type="drawable" name="stat_sys_battery_53" id="0x01080454" /&gt;
&lt;public type="drawable" name="stat_sys_battery_54" id="0x01080455" /&gt;
&lt;public type="drawable" name="stat_sys_battery_55" id="0x01080456" /&gt;
&lt;public type="drawable" name="stat_sys_battery_56" id="0x01080457" /&gt;
&lt;public type="drawable" name="stat_sys_battery_57" id="0x01080458" /&gt;
&lt;public type="drawable" name="stat_sys_battery_58" id="0x01080459" /&gt;
&lt;public type="drawable" name="stat_sys_battery_59" id="0x0108045a" /&gt;
&lt;public type="drawable" name="stat_sys_battery_61" id="0x0108045b" /&gt;
&lt;public type="drawable" name="stat_sys_battery_62" id="0x0108045c" /&gt;
&lt;public type="drawable" name="stat_sys_battery_63" id="0x0108045d" /&gt;
&lt;public type="drawable" name="stat_sys_battery_64" id="0x0108045e" /&gt;
&lt;public type="drawable" name="stat_sys_battery_65" id="0x0108045f" /&gt;
&lt;public type="drawable" name="stat_sys_battery_66" id="0x01080460" /&gt;
&lt;public type="drawable" name="stat_sys_battery_67" id="0x01080461" /&gt;
&lt;public type="drawable" name="stat_sys_battery_68" id="0x01080462" /&gt;
&lt;public type="drawable" name="stat_sys_battery_69" id="0x01080463" /&gt;
&lt;public type="drawable" name="stat_sys_battery_70" id="0x01080464" /&gt;
&lt;public type="drawable" name="stat_sys_battery_71" id="0x01080465" /&gt;
&lt;public type="drawable" name="stat_sys_battery_72" id="0x01080466" /&gt;
&lt;public type="drawable" name="stat_sys_battery_73" id="0x01080467" /&gt;
&lt;public type="drawable" name="stat_sys_battery_74" id="0x01080468" /&gt;
&lt;public type="drawable" name="stat_sys_battery_75" id="0x01080469" /&gt;
&lt;public type="drawable" name="stat_sys_battery_76" id="0x0108046a" /&gt;
&lt;public type="drawable" name="stat_sys_battery_77" id="0x0108046b" /&gt;
&lt;public type="drawable" name="stat_sys_battery_78" id="0x0108046c" /&gt;
&lt;public type="drawable" name="stat_sys_battery_79" id="0x0108046d" /&gt;
&lt;public type="drawable" name="stat_sys_battery_81" id="0x0108046e" /&gt;
&lt;public type="drawable" name="stat_sys_battery_82" id="0x0108046f" /&gt;
&lt;public type="drawable" name="stat_sys_battery_83" id="0x01080470" /&gt;
&lt;public type="drawable" name="stat_sys_battery_84" id="0x01080471" /&gt;
&lt;public type="drawable" name="stat_sys_battery_85" id="0x01080472" /&gt;
&lt;public type="drawable" name="stat_sys_battery_86" id="0x01080473" /&gt;
&lt;public type="drawable" name="stat_sys_battery_87" id="0x01080474" /&gt;
&lt;public type="drawable" name="stat_sys_battery_88" id="0x01080475" /&gt;
&lt;public type="drawable" name="stat_sys_battery_89" id="0x01080476" /&gt;
&lt;public type="drawable" name="stat_sys_battery_90" id="0x01080477" /&gt;
&lt;public type="drawable" name="stat_sys_battery_91" id="0x01080478" /&gt;
&lt;public type="drawable" name="stat_sys_battery_92" id="0x01080479" /&gt;
&lt;public type="drawable" name="stat_sys_battery_93" id="0x0108047a" /&gt;
&lt;public type="drawable" name="stat_sys_battery_94" id="0x0108047b" /&gt;
&lt;public type="drawable" name="stat_sys_battery_95" id="0x0108047c" /&gt;
&lt;public type="drawable" name="stat_sys_battery_96" id="0x0108047d" /&gt;
&lt;public type="drawable" name="stat_sys_battery_97" id="0x0108047e" /&gt;
&lt;public type="drawable" name="stat_sys_battery_98" id="0x0108047f" /&gt;
&lt;public type="drawable" name="stat_sys_battery_99" id="0x01080480" /&gt;
&lt;public type="drawable" name="stat_sys_battery_charge_anim6" id="0x01080481" /&gt;
&lt;public type="drawable" name="stat_sys_battery_charge_anim7" id="0x01080482" /&gt;
&lt;public type="drawable" name="stat_sys_battery_charge_anim8" id="0x01080483" /&gt;
&lt;public type="drawable" name="stat_sys_battery_charge_anim9" id="0x01080484" /&gt;
&lt;public type="drawable" name="stat_sys_battery_charge_anim10" id="0x01080485" /&gt;
&lt;public type="drawable" name="stat_sys_battery_charge_anim11" id="0x01080486" /&gt;
&lt;public type="drawable" name="stat_sys_battery_charge_anim12" id="0x01080487" /&gt;
&lt;public type="drawable" name="stat_sys_battery_charge_anim13" id="0x01080488" /&gt;
&lt;public type="drawable" name="stat_sys_battery_charge_anim14" id="0x01080489" /&gt;
&lt;public type="drawable" name="stat_sys_battery_charge_anim15" id="0x0108048a" /&gt;
&lt;public type="drawable" name="stat_sys_battery_charge_anim16" id="0x0108048b" /&gt;
&lt;public type="drawable" name="stat_sys_battery_charge_anim17" id="0x0108048c" /&gt;
&lt;public type="drawable" name="stat_sys_battery_charge_anim18" id="0x0108048d" /&gt;
&lt;public type="drawable" name="stat_sys_battery_charge_anim19" id="0x0108048e" /&gt;
</code></pre>

<p>I can also do 
<code>java -jar framework_helper.jar public.xml 100 20</code></p>

<p>And it will just add the battery mod.</p>

<h2>Notes</h2>

<p>-If you try and add something that already exists, the program will skip it properly. for instance stat<em>sys</em>battery<em>20 40 60 80 will not get added because it already exists in the public xml.
-In the future, I will try and have it generate a stat</em>sys<em>battery and a stat</em>sys<em>battery</em>charge automagically for you! For now, you still have to do these yourself</p>

<p>I'm sure that was confusing as hell, please read over and let me know if you have any questions</p>
