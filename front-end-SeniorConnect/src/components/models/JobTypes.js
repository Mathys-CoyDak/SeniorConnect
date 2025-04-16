/**
 * @typedef {Object} Job
 * @property {string} id - Unique identifier for the job
 * @property {string} title - Job title
 * @property {string} company - Company name
 * @property {string} [jobType] - Type of job (Part-time, Full-time, etc.)
 * @property {string} [location] - Job location
 * @property {string} [salary] - Salary range or amount
 * @property {string} [shortMission] - Short mission indicator
 * @property {string} [dailyRate] - Daily rate for contract jobs
 * @property {string} [matchPercentage] - Match percentage for recommended jobs
 * @property {string} postedTime - Time since job was posted (e.g., "2d ago")
 */

/**
 * @typedef {Object} Application
 * @property {string} id - Unique identifier for the application
 * @property {string} jobTitle - Title of the job applied for
 * @property {string} [company] - Company name
 * @property {string} date - Application date (YYYY-MM-DD)
 * @property {('pending'|'accepted'|'rejected')} status - Current application status
 */

// This file doesn't export anything, it's just for documentation
