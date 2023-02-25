package script.ai;

import script.dictionary;
import script.library.pet_lib;
import script.obj_id;
import script.string_id;

public class officer_pet extends script.base_script
{
    public officer_pet()
    {
    }
    public int OnAttach(obj_id self) throws InterruptedException
    {
        messageTo(self, "getAndFollowMaster", null, 3, false);
<<<<<<< HEAD
        messageTo(self, "verifyReinforcementsSkill", null, 3, false);
=======
>>>>>>> b69511aac62f968d19305ea6fd12278ad6f3b87c
        return SCRIPT_CONTINUE;
    }
    public int OnInitialize(obj_id self) throws InterruptedException
    {
        messageTo(self, "getAndFollowMaster", null, 3, false);
<<<<<<< HEAD
        messageTo(self, "verifyReinforcementsSkill", null, 3, false);
=======
>>>>>>> b69511aac62f968d19305ea6fd12278ad6f3b87c
        return SCRIPT_CONTINUE;
    }
    public int getAndFollowMaster(obj_id self, dictionary params) throws InterruptedException
    {
        setCondition(self, CONDITION_CONVERSABLE);
        obj_id master = getMaster(self);
        if (isIdNull(master))
        {
            return SCRIPT_CONTINUE;
        }
        pet_lib.doCommandNum(self, pet_lib.COMMAND_FOLLOW, master);
        return SCRIPT_CONTINUE;
    }
<<<<<<< HEAD
    public int verifyReinforcementsSkill(obj_id self, dictionary params) throws InterruptedException
    {
        obj_id master = getMaster(self);
        if (isIdNull(master))
        {
            return SCRIPT_CONTINUE;
        }
        if (!hasSkill(master, "expertise_of_reinforcements_1"))
        {
            sendSystemMessage(master, new string_id("spam", "off_pet_no_skill"));
            pet_lib.destroyOfficerPets(master);
        }
        return SCRIPT_CONTINUE;
    }
=======
>>>>>>> b69511aac62f968d19305ea6fd12278ad6f3b87c
}
