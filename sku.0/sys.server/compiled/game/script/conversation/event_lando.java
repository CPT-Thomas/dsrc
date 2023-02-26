package script.conversation;

import script.library.ai_lib;
import script.library.chat;
import script.library.groundquests;
import script.library.utils;
import script.library.factions;
import script.library.*;
import script.*;

public class event_lando extends script.base_script
{
    public event_lando()
    {
    }
    public static String c_stringFile = "conversation/event_lando";
    public boolean event_lando_condition__defaultCondition(obj_id player, obj_id npc) throws InterruptedException
    {
        return true;
    }
    public boolean event_lando_condition_playerStartedQuest(obj_id player, obj_id npc) throws InterruptedException
    {
        return groundquests.isQuestActive(player, "event_cantina_lando");
    }
    public boolean event_lando_condition_playerFinishedMainTask(obj_id player, obj_id npc) throws InterruptedException
    {
        return groundquests.isTaskActive(player, "event_cantina_lando", "talktolando");
    }
    public boolean event_lando_condition_townsPerson(obj_id player, obj_id npc) throws InterruptedException
    {
        float townFaction = factions.getFactionStanding(player, "townsperson");
        if (townFaction >= -1)
        {
            return true;
        }
        else 
        {
            return false;
        }
    }
    public boolean event_lando_condition_entertainer(obj_id player, obj_id npc) throws InterruptedException
    {
        String pTemplate = getSkillTemplate(player);
        if (pTemplate.contains("entertainer"))
        {
            return true;
        }
        else 
        {
            return false;
        }
    }
    public void event_lando_action_vendor(obj_id player, obj_id npc) throws InterruptedException
    {
        dictionary d = new dictionary();
        d.put("player", player);
        messageTo(npc, "showInventorySUI", d, 0, false);
    }
    public void event_lando_action_signalReward(obj_id player, obj_id npc) throws InterruptedException
    {
        groundquests.sendSignal(player, "lando_reward");
    }
    public void event_lando_action_grantQ1(obj_id player, obj_id npc) throws InterruptedException
    {
        int questId = questGetQuestId("quest/event_cantina_lando");
        groundquests.grantQuest(questId, player, npc, true);
    }
    public int event_lando_handleBranch1(obj_id player, obj_id npc, string_id response) throws InterruptedException
    {
        if (response.equals("s_165"))
        {
            if (event_lando_condition__defaultCondition(player, npc))
            {
                doAnimationAction(npc, "shrug");
                string_id message = new string_id(c_stringFile, "s_167");
                utils.removeScriptVar(player, "conversation.event_lando.branchId");
                chat.chat(npc, player, message);
                npcEndConversation(player);
                return SCRIPT_CONTINUE;
            }
        }
        if (response.equals("s_169"))
        {
            if (event_lando_condition__defaultCondition(player, npc))
            {
                doAnimationAction(npc, "hug");
                event_lando_action_signalReward(player, npc);
                string_id message = new string_id(c_stringFile, "s_171");
                utils.removeScriptVar(player, "conversation.event_lando.branchId");
                chat.chat(npc, player, message);
                npcEndConversation(player);
                return SCRIPT_CONTINUE;
            }
        }
        return SCRIPT_DEFAULT;
    }
    public int event_lando_handleBranch26(obj_id player, obj_id npc, string_id response) throws InterruptedException
    {
        if (response.equals("s_255"))
        {
            if (event_lando_condition__defaultCondition(player, npc))
            {
                doAnimationAction(npc, "conversation_1");
                string_id message = new string_id(c_stringFile, "s_257");
                int numberOfResponses = 0;
                boolean hasResponse = false;
                boolean hasResponse0 = false;
                if (event_lando_condition__defaultCondition(player, npc))
                {
                    ++numberOfResponses;
                    hasResponse = true;
                    hasResponse0 = true;
                }
                if (hasResponse)
                {
                    int responseIndex = 0;
                    string_id responses[] = new string_id[numberOfResponses];
                    if (hasResponse0)
                    {
                        responses[responseIndex++] = new string_id(c_stringFile, "s_259");
                    }
                    utils.setScriptVar(player, "conversation.event_lando.branchId", 27);
                    npcSpeak(player, message);
                    npcSetConversationResponses(player, responses);
                }
                else 
                {
                    utils.removeScriptVar(player, "conversation.event_lando.branchId");
                    chat.chat(npc, player, message);
                    npcEndConversation(player);
                }
                return SCRIPT_CONTINUE;
            }
        }
        if (response.equals("s_271"))
        {
            if (event_lando_condition__defaultCondition(player, npc))
            {
                doAnimationAction(npc, "shrug");
                string_id message = new string_id(c_stringFile, "s_273");
                utils.removeScriptVar(player, "conversation.event_lando.branchId");
                chat.chat(npc, player, message);
                npcEndConversation(player);
                return SCRIPT_CONTINUE;
            }
        }
        return SCRIPT_DEFAULT;
    }
    public int event_lando_handleBranch27(obj_id player, obj_id npc, string_id response) throws InterruptedException
    {
        if (response.equals("s_259"))
        {
            if (event_lando_condition__defaultCondition(player, npc))
            {
                string_id message = new string_id(c_stringFile, "s_261");
                int numberOfResponses = 0;
                boolean hasResponse = false;
                boolean hasResponse0 = false;
                if (event_lando_condition__defaultCondition(player, npc))
                {
                    ++numberOfResponses;
                    hasResponse = true;
                    hasResponse0 = true;
                }
                boolean hasResponse1 = false;
                if (event_lando_condition__defaultCondition(player, npc))
                {
                    ++numberOfResponses;
                    hasResponse = true;
                    hasResponse1 = true;
                }
                if (hasResponse)
                {
                    int responseIndex = 0;
                    string_id responses[] = new string_id[numberOfResponses];
                    if (hasResponse0)
                    {
                        responses[responseIndex++] = new string_id(c_stringFile, "s_263");
                    }
                    if (hasResponse1)
                    {
                        responses[responseIndex++] = new string_id(c_stringFile, "s_267");
                    }
                    utils.setScriptVar(player, "conversation.event_lando.branchId", 28);
                    npcSpeak(player, message);
                    npcSetConversationResponses(player, responses);
                }
                else 
                {
                    utils.removeScriptVar(player, "conversation.event_lando.branchId");
                    chat.chat(npc, player, message);
                    npcEndConversation(player);
                }
                return SCRIPT_CONTINUE;
            }
        }
        return SCRIPT_DEFAULT;
    }
    public int event_lando_handleBranch28(obj_id player, obj_id npc, string_id response) throws InterruptedException
    {
        if (response.equals("s_263"))
        {

            if (event_lando_condition_entertainer(player, npc))
            {
                doAnimationAction(npc, "face_wink");
                groundquests.grantQuest(player, "event_cantina_lando");
                string_id message = new string_id(c_stringFile, "s_265");
                utils.removeScriptVar(player, "conversation.event_lando.branchId");
                chat.chat(npc, player, message);
                npcEndConversation(player);
                return SCRIPT_CONTINUE;
            }
	    else
            {
                doAnimationAction(npc, "strut");
                string_id message = new string_id(c_stringFile, "s_269");
                utils.removeScriptVar(player, "conversation.event_lando.branchId");
                chat.chat(npc, player, message);
                npcEndConversation(player);
                return SCRIPT_CONTINUE;
            }
        }
        if (response.equals("s_267"))
        {
	    if (event_lando_condition_townsPerson(player, npc))
            {
		event_lando_action_vendor(player, npc);
                doAnimationAction(npc, "handshake_tandem");
                string_id message = new string_id(c_stringFile, "fence_lando");
                utils.removeScriptVar(player, "conversation.event_lando.branchId");
                chat.chat(npc, player, message);
                npcEndConversation(player);
                return SCRIPT_CONTINUE;
            }
            else
            {
                doAnimationAction(npc, "offer_affection");
                string_id message = new string_id(c_stringFile, "s_269");
                utils.removeScriptVar(player, "conversation.event_lando.branchId");
                chat.chat(npc, player, message);
                npcEndConversation(player);
                return SCRIPT_CONTINUE;
            }
        }
        return SCRIPT_DEFAULT;
    }
    public int OnInitialize(obj_id self) throws InterruptedException
    {
        if ((!isMob(self)) || (isPlayer(self)))
        {
            detachScript(self, "conversation.event_lando");
        }
        setCondition(self, CONDITION_CONVERSABLE);
        return SCRIPT_CONTINUE;
    }
    public int OnAttach(obj_id self) throws InterruptedException
    {
        setCondition(self, CONDITION_CONVERSABLE);
        return SCRIPT_CONTINUE;
    }
    public int OnObjectMenuRequest(obj_id self, obj_id player, menu_info menuInfo) throws InterruptedException
    {
        int menu = menuInfo.addRootMenu(menu_info_types.CONVERSE_START, null);
        menu_info_data menuInfoData = menuInfo.getMenuItemById(menu);
        menuInfoData.setServerNotify(false);
        setCondition(self, CONDITION_CONVERSABLE);
        return SCRIPT_CONTINUE;
    }
    public int OnIncapacitated(obj_id self, obj_id killer) throws InterruptedException
    {
        clearCondition(self, CONDITION_CONVERSABLE);
        detachScript(self, "conversation.event_lando");
        return SCRIPT_CONTINUE;
    }
    public boolean npcStartConversation(obj_id player, obj_id npc, String convoName, string_id greetingId, prose_package greetingProse, string_id[] responses) throws InterruptedException
    {
        Object[] objects = new Object[responses.length];
        System.arraycopy(responses, 0, objects, 0, responses.length);
        return npcStartConversation(player, npc, convoName, greetingId, greetingProse, objects);
    }
     public int OnStartNpcConversation(obj_id self, obj_id player) throws InterruptedException
    {
        obj_id npc = self;
        if (ai_lib.isInCombat(npc) || ai_lib.isInCombat(player))
        {
            return SCRIPT_OVERRIDE;
        }
        if (event_lando_condition_playerStartedQuest(player, npc))
        {
            doAnimationAction(npc, "rose");
            string_id message = new string_id(c_stringFile, "s_163");
            int numberOfResponses = 0;
            boolean hasResponse = false;
            boolean hasResponse0 = false;
     	if (event_lando_condition_playerStartedQuest(player, npc))
            {
                ++numberOfResponses;
                hasResponse = true;
                hasResponse0 = true;
            }
            boolean hasResponse1 = false;
            if (event_lando_condition_playerFinishedMainTask(player, npc))
            {
                ++numberOfResponses;
                hasResponse = true;
                hasResponse1 = true;
            }
            if (hasResponse)
            {
                int responseIndex = 0;
                string_id responses[] = new string_id[numberOfResponses];
                if (hasResponse0)
                {
                    responses[responseIndex++] = new string_id(c_stringFile, "s_165");
                }
                if (hasResponse1)
                {
                    responses[responseIndex++] = new string_id(c_stringFile, "s_169");
                }
                utils.setScriptVar(player, "conversation.event_lando.branchId", 1);
                npcStartConversation(player, npc, "event_lando", message, responses);
            }
            else 
            {
                chat.chat(npc, player, message);
            }
            return SCRIPT_CONTINUE;
        }
        if (event_lando_condition__defaultCondition(player, npc))
        {
            doAnimationAction(npc, "hug_tandem");
            string_id message = new string_id(c_stringFile, "s_253");
            int numberOfResponses = 0;
            boolean hasResponse = false;
            boolean hasResponse0 = false;
            if (event_lando_condition__defaultCondition(player, npc))
            {
                ++numberOfResponses;
                hasResponse = true;
                hasResponse0 = true;
            }
            boolean hasResponse1 = false;
            if (event_lando_condition__defaultCondition(player, npc))
            {
                ++numberOfResponses;
                hasResponse = true;
                hasResponse1 = true;
            }
            if (hasResponse)
            {
                int responseIndex = 0;
                string_id responses[] = new string_id[numberOfResponses];
                if (hasResponse0)
                {
                    responses[responseIndex++] = new string_id(c_stringFile, "s_255");
                }
                if (hasResponse1)
                {
                    responses[responseIndex++] = new string_id(c_stringFile, "s_271");
                }
                utils.setScriptVar(player, "conversation.event_lando.branchId", 26);
                npcStartConversation(player, npc, "event_lando", message, responses);
            }
            else 
            {
                chat.chat(npc, player, message);
            }
            return SCRIPT_CONTINUE;
        }
        chat.chat(npc, "Error:  All conditions for OnStartNpcConversation were false.");
        return SCRIPT_CONTINUE;
    }
    public int OnNpcConversationResponse(obj_id self, String conversationId, obj_id player, string_id response) throws InterruptedException
    {
        if (!conversationId.equals("event_lando"))
        {
            return SCRIPT_CONTINUE;
        }
        obj_id npc = self;
        int branchId = utils.getIntScriptVar(player, "conversation.event_lando.branchId");
	if (branchId == 1 && event_lando_handleBranch1(player, npc, response) == SCRIPT_CONTINUE)
        {
            return SCRIPT_CONTINUE;
        }
        if (branchId == 26 && event_lando_handleBranch26(player, npc, response) == SCRIPT_CONTINUE)
        {
            return SCRIPT_CONTINUE;
        }
        if (branchId == 27 && event_lando_handleBranch27(player, npc, response) == SCRIPT_CONTINUE)
        {
            return SCRIPT_CONTINUE;
        }
        if (branchId == 28 && event_lando_handleBranch28(player, npc, response) == SCRIPT_CONTINUE)
        {
            return SCRIPT_CONTINUE;
        }
        chat.chat(npc, "Error:  Fell through all branches and responses for OnNpcConversationResponse.");
        utils.removeScriptVar(player, "conversation.event_lando.branchId");
        return SCRIPT_CONTINUE;
    }
}
