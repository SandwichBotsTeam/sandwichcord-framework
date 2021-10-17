/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Copyright 2021 Juan Acuña                                                   *
 *                                                                             *
 * Licensed under the Apache License, Version 2.0 (the "License");             *
 * you may not use this file except in compliance with the License.            *
 * You may obtain a copy of the License at                                     *
 *                                                                             *
 *     http://www.apache.org/licenses/LICENSE-2.0                              *
 *                                                                             *
 * Unless required by applicable law or agreed to in writing, software         *
 * distributed under the License is distributed on an "AS IS" BASIS,           *
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.    *
 * See the License for the specific language governing permissions and         *
 * limitations under the License.                                              *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

package com.jaxsandwich.sandwichcord.models;

import java.util.Collection;

import com.jaxsandwich.sandwichcord.development.NotDocumented;

/**
 * @author Juan Acuña
 * @version 1.0
 * @since 0.9.0
 */
@NotDocumented
public class SlashSubGroup extends SlashSubObject{
	private String name;
	private String description;
	private SlashCommandObject command;
	private SlashSubCommand[] subCommands;
	public SlashSubGroup(String name, String description) {
		this.name = name;
		this.description = description;
	}
	public SlashSubGroup(String name, String description, Collection<SlashSubCommand> subCommands) {
		this.name = name.toLowerCase();
		this.description = description.toLowerCase();
		this.subCommands = new SlashSubCommand[subCommands.size()];
		subCommands.toArray(this.subCommands);
		for(SlashSubCommand s : this.subCommands) {
			s.setSubGroup(this);
		}
	}
	public String getDescription() {
		return description;
	}
	public SlashSubCommand[] getSubCommands() {
		return subCommands;
	}
	public String getName() {
		return name;
	}
	public SlashCommandObject getCommand() {
		return command;
	}
	protected void setCommand(SlashCommandObject command) {
		this.command=command;
		for(SlashSubCommand s : this.subCommands) {
			s.setCommand(command);
		}
	}
	public String getPath() {
		return ((command!=null?command.getName():"[?]") + "/" + name).toLowerCase();
	}
	@Override
	public String getPattern() {
		return (command!=null?">":"[?]") + "/%/" + ((subCommands!=null) && (subCommands.length>0)?"#["+subCommands.length+"]":"[?]");
	}
}
