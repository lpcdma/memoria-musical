package sfs2x.extensions.games.battlefarm.main;

import java.util.List;

import sfs2x.extensions.games.battlefarm.beans.GameBean;
import sfs2x.extensions.games.battlefarm.beans.GameMapBean;
import sfs2x.extensions.games.battlefarm.utils.Commands;


import com.smartfoxserver.v2.entities.Room;
import com.smartfoxserver.v2.entities.User;
import com.smartfoxserver.v2.entities.data.ISFSObject;
import com.smartfoxserver.v2.extensions.BaseClientRequestHandler;

/**
 * RestartHandler: manages restart messages from a user
 * 
 * @author Ing. Ignazio Locatelli
 * @version 1.0
 */
public class RestartHandler extends BaseClientRequestHandler
{
	/**
	 * Handle restart game request from user
	 * 
	 * @param sender	The user that made the request
	 * @param params	The parameters passed with the request
	 */
	@Override
	public void handleClientRequest(User sender, ISFSObject params)
	{
		// Retrieve user's room
		Room room = null;
		List<Room> rooms = sender.getJoinedRooms();
		if (rooms.size() > 0) room = rooms.get(0);  // User can be only in 1 room at a time

		trace("BattleFarm: user " + sender.getName() + " restarted match " + room.getId());

		// Get game bean
		GameBean gameBean = ((BattleFarmExtension) (getParentExtension())).getGames().get(room.getId());

		if (gameBean != null)
		{
			// Reset the game
			gameBean.reset();

			// Retrieve map data and send to players
			GameMapBean gameMapBean = gameBean.getBaseGameMapBean();

			// Retrieve pre-generated SFSObject
			ISFSObject resObj = gameMapBean.getMapObject();

			// Add information relative to master and slave
			resObj.putInt("pId1",gameBean.getMaster());
			resObj.putInt("pId2",gameBean.getSlave());

			// Send map data to players
			send(Commands.CMD_MAP_DATA, resObj, room.getUserList());

			// Set the start time of the game ahead of 3 1/2 seconds to compensate the delay
			gameBean.startGame(room.getUserList(),(BattleFarmExtension)getParentExtension());
		}
	}
}