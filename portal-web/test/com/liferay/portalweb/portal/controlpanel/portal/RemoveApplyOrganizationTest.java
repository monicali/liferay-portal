/**
 * Copyright (c) 2000-2009 Liferay, Inc. All rights reserved.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.liferay.portalweb.portal.controlpanel.portal;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * <a href="RemoveApplyOrganizationTest.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class RemoveApplyOrganizationTest extends BaseTestCase {
	public void testRemoveApplyOrganization() throws Exception {
		int label = 1;

		while (label >= 1) {
			switch (label) {
			case 1:

				boolean InControlPanel = selenium.isElementPresent(
						"link=Back to My Community");

				if (InControlPanel) {
					label = 2;

					continue;
				}

				selenium.click(RuntimeVariables.replace(
						"//div[@id='_145_myPlacesContainer']/ul/li[2]/a/span[1]"));
				selenium.waitForPageToLoad("30000");
				selenium.click(RuntimeVariables.replace("link=Control Panel"));
				selenium.waitForPageToLoad("30000");

			case 2:
				selenium.click(RuntimeVariables.replace("link=Organizations"));
				selenium.waitForPageToLoad("30000");
				selenium.typeKeys("_126_keywords",
					RuntimeVariables.replace("Selenium"));
				selenium.type("_126_keywords",
					RuntimeVariables.replace("Selenium"));
				selenium.click(RuntimeVariables.replace(
						"//input[@value='Search']"));
				selenium.waitForPageToLoad("30000");
				selenium.click("//td[8]/ul/li/strong/span");

				for (int second = 0;; second++) {
					if (second >= 60) {
						fail("timeout");
					}

					try {
						if (selenium.isElementPresent("link=Assign Members")) {
							break;
						}
					}
					catch (Exception e) {
					}

					Thread.sleep(1000);
				}

				selenium.click(RuntimeVariables.replace("link=Assign Members"));
				selenium.waitForPageToLoad("30000");
				selenium.click("_126_allRowIds");
				selenium.click(RuntimeVariables.replace(
						"//input[@value='Update Associations']"));
				selenium.waitForPageToLoad("30000");
				assertTrue(selenium.isTextPresent(
						"Your request processed successfully."));

			case 100:
				label = -1;
			}
		}
	}
}