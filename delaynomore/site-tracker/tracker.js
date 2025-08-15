console.log("🚀 tracker.js loaded");

const TASK_MAP = {
  "example.com": 1,
  "leetcode.com": 2,
  "youtube.com": 3
};

// Get domain name from current tab
let currentDomain = window.location.hostname.replace("www.", "");
let taskId = TASK_MAP[currentDomain];

if (taskId) {
  console.log(`Tracking: ${currentDomain} (Task ID: ${taskId})`);

  // On tab focus: try to start the task
  window.addEventListener("focus", () => {
    fetch(`http://localhost:8080/tasks/${taskId}/start`, { method: "POST" })
  .then(res => {
    if (!res.ok) {
      return res.text().then(msg => {
        console.warn("❌ Cooldown active:", msg);
        // Stop task immediately
        fetch(`http://localhost:8080/tasks/${taskId}/stop`, { method: "POST" });
        // 🔁 Redirect to cooldown page
        window.location.href = chrome.runtime.getURL("cooldown.html");
      });
    } else {
      console.log("✅ Task started.");
    }
  })
  .catch(err => console.error("Start failed:", err));

  });

  // On tab close, switch, or hide: stop the task
  document.addEventListener("visibilitychange", () => { 
  if (document.visibilityState === "hidden") {
    fetch(`http://localhost:8080/tasks/${taskId}/stop`, { method: "POST" })
      .then(() => {
        console.log("⏹️ Task stopped");
        // ⏩ Redirect after stop
        window.location.href = chrome.runtime.getURL("cooldown.html");

      })
      .catch(err => console.warn("Stop error:", err));
  }
});

}
